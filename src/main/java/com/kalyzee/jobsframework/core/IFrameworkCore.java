package com.kalyzee.jobsframework.core;

public interface IFrameworkCore {
	
	/**
	 * Se mettre en attente de message
	 * @throws JobsFrameworkCoreException 
	 */
	void start() throws JobsFrameworkCoreException;

	/**
	 * Liberation des ressources
	 * @throws StoppingException 
	 */
	void stop() throws StoppingException;
	
	/**
	 * 
	 */
	void addJobListener(IJobCoreListener listener);
}
