package com.kalyzee.jobsframework.services.servicelocator;

public interface IServiceLocator {
	void createSubContext(String subcontext) throws ServiceLocatorException;

	void bind(String name, Object object) throws ServiceLocatorException;
	Object lookup(String name) throws ServiceLocatorException;
	
	void close() throws ServiceLocatorException;
}
