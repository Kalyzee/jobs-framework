package com.kalyzee.jobsframework.messenger;

import java.util.Properties;

import com.kalyzee.jobsframework.core.StoppingException;



public interface IMessengerClient {
	
	void receive() throws MessengerClientException;
	void addMessageListener(IMessageClientListener message);
	void init(Properties properties) throws MessengerClientException;
	void stop() throws StoppingException;
}
