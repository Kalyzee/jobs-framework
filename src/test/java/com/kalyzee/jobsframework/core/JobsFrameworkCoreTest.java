package com.kalyzee.jobsframework.core;

import javax.jms.Message;
import javax.naming.NamingException;

import org.junit.Test;

/**
 * 
 * @author Ludovic Bouguerra 
 *
 */
public class JobsFrameworkCoreTest {
	
	
	@Test
	public void testStart() throws NamingException{
		JobsFrameworkCore jobs = new JobsFrameworkCore("vm://localhost", "test");
		JobFrameworkListener jobList = new JobFrameworkListener();
		jobs.addJobListener(jobList);
		//jobs.start();
		
	}
}

class JobFrameworkListener implements IJobCoreListener{

	boolean status = false;
	
	@Override
	public void onNewJob(Message message) {
		status = true;
		
	}
	
	public boolean getStatus(){
		return status;
	}
	
}