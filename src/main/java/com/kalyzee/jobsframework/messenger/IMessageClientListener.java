package com.kalyzee.jobsframework.messenger;

import java.util.EventListener;

import javax.jms.Message;

public interface IMessageClientListener extends EventListener{

	void onMessage(Message message);
	
}
