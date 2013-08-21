package com.kalyzee.jobsframework.services;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.qpid.proton.messenger.MessengerException;

public class MessengerService implements IMessengerService, IService{

	
	@Override
	public void sendQueueMessage(String service, String queue,
			Properties message) throws MessengerException {


        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(service);

            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queue);
            MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			
			Message messageContent = session.createMessage();
			
			for (Object key : message.keySet()) {
				System.out.println((String) key + "  " +message.getProperty((String) key));
				messageContent.setStringProperty((String) key, message.getProperty((String) key));
				
			}
			
			producer.send(messageContent);
			connection.close();
			session.close();
		} catch (JMSException e) {
			throw new MessengerException();

		}
	}

	@Override
	public void sendTopicMessage(String service, String topic,
			Properties message) throws MessengerException {
		try{
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(service);

            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic(topic);
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			Message messageContent = session.createMessage();
			
			for (Object key : message.keySet()) {
				
				messageContent.setStringProperty((String) key, message.getProperty((String) key));
				
			}
			
			producer.send(messageContent);
			connection.close();
			session.close();
		}catch(JMSException e){
			throw new MessengerException();
		}
	}

	
	public void close(){

	}

	@Override
	public void init(Properties prop) throws ServiceException {

		
	}

}
