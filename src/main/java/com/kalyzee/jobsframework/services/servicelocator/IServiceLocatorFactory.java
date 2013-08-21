package com.kalyzee.jobsframework.services.servicelocator;

public interface IServiceLocatorFactory {
	
	IServiceLocator getServiceLocator() throws ServiceLocatorException;
	
}
