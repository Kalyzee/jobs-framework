package com.kalyzee.jobsframework.services.servicelocator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ServiceLocatorTest {
	
	private IServiceLocator serviceLocator;
	
	@Before
	@Test
	public void initServiceLocator() throws ServiceLocatorException{
		serviceLocator = ServiceLocatorFactory.getInstance().getServiceLocator();
		Assert.assertEquals(serviceLocator, ServiceLocatorFactory.getInstance().getServiceLocator());
	}
	
	@Test
	public void testBind() throws ServiceLocatorException{
		Object o = new Object();
		serviceLocator.bind("test", o);
		Assert.assertEquals(o, serviceLocator.lookup("test"));
	}
}
