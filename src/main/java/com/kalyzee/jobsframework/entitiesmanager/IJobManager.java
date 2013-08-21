package com.kalyzee.jobsframework.entitiesmanager;

import com.kalyzee.jobsframework.entities.IJob;

public interface IJobManager {
	/**
	 * 
	 * @param id
	 * @return
	 * @throws JobNotFoundException
	 */
	IJob findJobById(int id) throws JobNotFoundException;
	
	/**
	 * 
	 * @param id
	 * @param jobStatus
	 * @throws JobNotFoundException
	 */
	void setJobStatus(int id, int jobStatus) throws JobNotFoundException;
	
	/**
	 * 
	 * @param id
	 * @param url
	 */
	void addCallbackUrlForJob(int id, String url) throws JobNotFoundException;
	
	/**
	 * 
	 * @param id
	 * @param url
	 * @throws URLNotFoundException
	 */
	void removeCallbackUrlForJob(int id, String url) throws URLNotFoundException;
}
