package com.kalyzee.jobsframework.entities;

import java.util.List;

/**
 * 
 * @author Ludovic Bouguerra <ludovic.bouguerra@kalyzee.com> 
 *
 */
public interface IJob {
	
	/**
	 * 
	 * @return jobId
	 */
	int getId();

	/**
	 * 
	 * @return
	 */
	int getStatus();
	
	/**
	 * 
	 * @param id
	 */
	void setId(int id);
	
	/**
	 * 
	 * @param status
	 */
	void setStatus(int status);
	
	/**
	 * Returns the callbacks URL for this job
	 * @return List<String> Callbacks URl
	 */
	List<String> getCallBacksURL();
	
	/**
	 * 
	 * @param url
	 */
	void addCallbackUrl(String url);
	
	/**
	 * 
	 * @param url
	 */
	void removeCallbackUrl(String url);
	
	/**
	 * 
	 * @param urls
	 */
	void setCallbackUrl(List<String> urls);
}
