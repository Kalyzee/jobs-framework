package com.kalyzee.jobsframework.core;

import java.util.EventListener;

import javax.jms.Message;

public interface IJobCoreListener extends EventListener{
	void onNewJob(Message message);
}
