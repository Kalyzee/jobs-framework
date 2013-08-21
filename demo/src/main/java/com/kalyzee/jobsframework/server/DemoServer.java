package com.kalyzee.jobsframework.server;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class DemoServer {
	
	/**
	 * Server demonstration using Kalyzee Jobs Framework
	 * @param args 
	 */
	public static void main(String[] args) {
		 try {
             // Create a ConnectionFactory
             ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

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

             Message message = session.createMessage();
             // Tell the producer to send the message
             System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
             producer.send(message);

             // Clean up
             session.close();
             connection.close();
         }
         catch (Exception e) {
             System.out.println("Caught: " + e);
             e.printStackTrace();
         }
 
	
	}
	
}
