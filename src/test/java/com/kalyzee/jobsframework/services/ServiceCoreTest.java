package com.kalyzee.jobsframework.services;

import java.util.Properties;


import org.junit.Before;
import org.junit.Test;

import com.kalyzee.jobsframework.services.servicelocator.IServiceLocator;
import com.kalyzee.jobsframework.services.servicelocator.ServiceLocator;
import com.kalyzee.jobsframework.services.servicelocator.ServiceLocatorException;

public class ServiceCoreTest {
	
	private IServiceLocator serviceLocator;
	
	@Before
	public void init() throws ServiceLocatorException{
		serviceLocator = ServiceLocator.getInstance();
	}
	
	
	@Test
	public void testCreateServiceCore() throws ServiceException, ServiceLocatorException{
		Properties properties = new Properties();
		serviceLocator.bind("ServiceCore", ServiceCoreFactory.getInstance().createServiceCore(properties));
	
		//Assert.assertNotNull(jobFrameworkCore);
		
	}
	
}
