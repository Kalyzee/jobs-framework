package com.kalyzee.jobsframework.messenger;


import org.junit.Test;


public class MessengerClientTest {
	
	
	@Test
	public void testMessenger(){
		
		/*try {
			IMessengerClient messenger = new MessengerClient();
			MessengerListener messengerListener = new MessengerListener();
			messenger.addMessageListener(messengerListener);
	        // Create a ConnectionFactory
	        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
	
	        // Create a Connection
	        Connection connection = connectionFactory.createConnection();
	        connection.start();
	
	        // Create a Session
	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	
	        // Create the destination (Topic or Queue)
	        Destination destination = session.createQueue("test");
	
	        // Create a MessageProducer from the Session to the Topic or Queue
	        MessageProducer producer = session.createProducer(destination);
	        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        // Create a messages
	        String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
	        TextMessage message = session.createTextMessage(text);
	
	        // Tell the producer to send the message
	        System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
	        producer.send(message);

		
	        Properties properties = new Properties();
	        properties.setProperty("messenger.url", "vm://localhost");
	        properties.setProperty("messenger.queue", "test");

	        messenger.init(properties);
			messenger.receive();
			
			Assert.assertEquals(messengerListener.getLastMessage(), message);
			
		} catch (MessengerClientException e) {
			Assert.fail();
		} catch (JMSException e) {
			Assert.fail();
		}*/
		
		
	}
	
}
/*
class MessengerListener implements IMessageClientListener{

	private Message message;
	
	@Override
	public void onMessage(Message message) {
		this.message = message; 
		
	}
	
	public Message getLastMessage(){
		return message;
	}
}
*/