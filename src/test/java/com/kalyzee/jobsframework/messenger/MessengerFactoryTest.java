package com.kalyzee.jobsframework.messenger;

import org.junit.Test;

import junit.framework.Assert;

public class MessengerFactoryTest {
	
	@Test
	public void testGetInstance(){
		
		Assert.assertEquals(MessengerClientFactory.getInstance(), MessengerClientFactory.getInstance());
		
		
	}
	
}
