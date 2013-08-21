package com.kalyzee.jobsframework.messenger;

import java.util.Properties;



public class MessengerClientFactory implements IMessengerClientFactory{
	private static MessengerClientFactory instance;
	
	private MessengerClientFactory() {
		
	}
	
	@Override
	public IMessengerClient createMessenger(Properties properties) throws MessengerClientException{
		MessengerClient messenger = new MessengerClient();
		messenger.init(properties);
		return messenger;
	}
	
	
	public static MessengerClientFactory getInstance(){
		if (instance == null){
			instance = new MessengerClientFactory();
		}
		return instance;
	}
	
}
