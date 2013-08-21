package com.kalyzee.jobsframework.services;


import junit.framework.Assert;

import org.junit.Test;

public class ServiceCoreFactoryTest {
	
	@Test
	public void testGetInstance(){
		Assert.assertNotNull(ServiceCoreFactory.getInstance());
		Assert.assertEquals(ServiceCoreFactory.getInstance(), ServiceCoreFactory.getInstance());
	}
	
	@Test
	public void testCreateServiceCore() throws ServiceException{
		//Properties properties = new Properties();
		//Assert.assertTrue(ServiceCoreFactory.getInstance().createServiceCore(properties) instanceof IService);

	}
	
	
}
