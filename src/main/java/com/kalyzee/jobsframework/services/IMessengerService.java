package com.kalyzee.jobsframework.services;


import java.util.Properties;

import org.apache.qpid.proton.messenger.MessengerException;


public interface IMessengerService {
	
	void sendQueueMessage(String service, String queue, Properties properties) throws MessengerException;
	
	void sendTopicMessage(String service, String queue, Properties properties) throws MessengerException;
	
}
