package com.kalyzee.jobsframework.messenger;

import java.util.Properties;

public interface IMessengerClientFactory {
	public IMessengerClient createMessenger(Properties properties) throws MessengerClientException;
}
