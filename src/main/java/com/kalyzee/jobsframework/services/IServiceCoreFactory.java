package com.kalyzee.jobsframework.services;

import java.util.Properties;

public interface IServiceCoreFactory {
	
	public IService createServiceCore(Properties properties) throws ServiceException; 
	

}
