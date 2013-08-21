package com.kalyzee.jobsframework.core;

import java.util.Properties;

import com.kalyzee.jobsframework.services.ServiceCoreFactory;
import com.kalyzee.jobsframework.services.ServiceException;
import com.kalyzee.jobsframework.services.servicelocator.ServiceLocatorException;
import com.kalyzee.jobsframework.services.servicelocator.ServiceLocatorFactory;

public class JobFrameworkCoreFactory implements IJobFrameworkCoreFactory{

	private static IJobFrameworkCoreFactory instance;
	
	public void init(Properties properties) throws JobsFrameworkCoreException{
		try {
			ServiceLocatorFactory.getInstance().getServiceLocator().bind("jobsframework/service_core", ServiceCoreFactory.getInstance().createServiceCore(properties));
		} catch (ServiceLocatorException e) {
			throw new JobsFrameworkCoreException();
			
		} catch (ServiceException e) {
			throw new JobsFrameworkCoreException();
		}
	}
	
	@Override
	public IFrameworkCore createJobFrameworkCore(String server, String queue) {
		return new JobsFrameworkCore(server, queue);
	}
	
	public static IJobFrameworkCoreFactory getInstance(){
		if (instance == null){
			instance = new JobFrameworkCoreFactory();
		}
		return instance;
	}

	@Override
	public IFrameworkCore createJobFrameworkCore(String server, String queue,
			String username, String password) {
		return new JobsFrameworkCore(server, queue, username, password);
	}
	
	
}
