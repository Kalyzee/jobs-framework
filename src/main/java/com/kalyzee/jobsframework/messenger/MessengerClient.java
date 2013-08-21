package com.kalyzee.jobsframework.messenger;


import java.util.Properties;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.swing.event.EventListenerList;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.kalyzee.jobsframework.core.StoppingException;

public class MessengerClient implements IMessengerClient, ExceptionListener{
	
	
	private Session session;
	private Connection connection;
	
	private MessageConsumer consumer;
	/**
	 * File d'attente à consulter
	 */
	private EventListenerList listeners = new EventListenerList();
	
	
	public void init(Properties properties) throws MessengerClientException{

		try{
			ActiveMQConnectionFactory connectionFactory = null;
			if (properties.getProperty("messenger.username") != null && properties.getProperty("messenger.password") != null){
		        connectionFactory = new ActiveMQConnectionFactory(properties.getProperty("messenger.username"), properties.getProperty("messenger.password"), properties.getProperty("messenger.url"));

			}
			else {
				connectionFactory = new ActiveMQConnectionFactory(properties.getProperty("messenger.url"));
			}
	        
	
	        // Create a Connection
	        connection = connectionFactory.createConnection();
	        connection.start();
	
	        connection.setExceptionListener(this);
	
	        // Create a Session
	        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	
	        // Create the destination (Topic or Queue)
	        Destination destination = session.createQueue(properties.getProperty("messenger.queue"));
	
	        // Create a MessageConsumer from the Session to the Topic or Queue
	        consumer = session.createConsumer(destination);
		}catch(JMSException e){
			throw new MessengerClientException(e.getMessage());
		}

	}
	
	public MessengerClient(){
	}
	

	@Override
	public void receive() throws MessengerClientException{

		try {
			Message message = consumer.receive();
			fireNewMessage(message);
		} catch (JMSException e) {
			throw new MessengerClientException(e.getMessage());
		}
	}
	
	protected IMessageClientListener[] getMessengerListener(){
		return listeners.getListeners(IMessageClientListener.class);
	}
	
	protected void fireNewMessage(Message message){
		for (IMessageClientListener messageListener : getMessengerListener()){
			messageListener.onMessage(message);
		}
	}

	@Override
	public void addMessageListener(IMessageClientListener message) {
		listeners.add(IMessageClientListener.class, message);
	}

	@Override
	public void onException(JMSException arg0) {
		//-- TODO add information dans les fichiers logs --
		//System.out.println(arg0);
		
	}

	@Override
	public void stop() throws StoppingException {
		try {
			consumer.close();
			session.close();
		} catch (JMSException e) {
			throw new StoppingException();
		}
	
	}

}
