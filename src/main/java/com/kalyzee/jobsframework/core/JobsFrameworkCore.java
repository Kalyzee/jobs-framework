package com.kalyzee.jobsframework.core;

import java.util.Properties;

import javax.jms.Message;
import javax.swing.event.EventListenerList;

import com.kalyzee.jobsframework.messenger.IMessageClientListener;
import com.kalyzee.jobsframework.messenger.IMessengerClient;
import com.kalyzee.jobsframework.messenger.MessengerClientException;
import com.kalyzee.jobsframework.messenger.MessengerClientFactory;

public class JobsFrameworkCore implements IFrameworkCore, IMessageClientListener{
	
	private EventListenerList listeners = new EventListenerList();
	private IMessengerClient messenger;
	private Properties properties;
	
	public JobsFrameworkCore(String server, String jobQueue){
		
		properties = new Properties();
		properties.setProperty("messenger.url", server);
		properties.setProperty("messenger.queue", jobQueue);
		
	}
	
	public JobsFrameworkCore(String server, String jobQueue, String username, String password){
		this(server, jobQueue);
		properties.setProperty("messenger.username", username);
		properties.setProperty("messenger.password", password);
	}
	
	@Override
	public void start() throws JobsFrameworkCoreException {
		try {
			messenger = MessengerClientFactory.getInstance().createMessenger(properties); 
			messenger.addMessageListener(this);
			while(true){
				messenger.receive();
			}
		} catch (MessengerClientException e) {
			throw new JobsFrameworkCoreException();
		}

		
	}
	
	/**
	 * Clean all ressources
	 * @throws StoppingException 
	 */
	public void stop() throws StoppingException{
		messenger.stop();
	}

	@Override
	public void addJobListener(IJobCoreListener listener) {
		listeners.add(IJobCoreListener.class, listener);
	}

	public void removeJobListener(IJobCoreListener listener) {
		listeners.remove(IJobCoreListener.class, listener);
	}

	public IJobCoreListener[] getJobCoreListener(){
		return listeners.getListeners(IJobCoreListener.class);
	}
	
	@Override
	public void onMessage(Message message) {
		fireNewJob(message);
	}	
	
	
	public void fireNewJob(Message message){
		for (IJobCoreListener job : getJobCoreListener()){
			job.onNewJob(message);
		}
	}
	
}
