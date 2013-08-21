package com.kalyzee.jobsframework.services;

import java.util.Properties;


import org.junit.Test;




public class MessengerServiceTest {
	
	@Test
	public void testMessengerService(){
		
		
		
		Properties properties = new Properties();
		properties.setProperty("messenger.url", "vm://localhost");
		properties.setProperty("messenger.queue", "vm://localhost");
		properties.setProperty("job.id", "vm://localhost");
		/*
		MessengerClient mc = new MessengerClient();
		MessageListener ml = new MessageListener();
		mc.addMessageListener(ml);
		MessengerService ms = new MessengerService();
		try {
			ms.init(properties);
			ms.sendQueueMessage("vm://localhost", "test",  properties);
			//mc.receive();
			//Assert.assertTrue(ml.isMessage());
		} catch (MessengerException e) {
			e.printStackTrace();
		}  catch (ServiceException e) {
			e.printStackTrace();
		} catch (MessengerClientException e) {
			e.printStackTrace();
		}
		*/
		
	}
	
}
/*
class MessageListener implements IMessageClientListener{
	
	private boolean message = false; 
	
	@Override
	public void onMessage(Message messaging) {
		message = true;
	}
	
	public boolean isMessage(){
		return message;
	}
	
}*/