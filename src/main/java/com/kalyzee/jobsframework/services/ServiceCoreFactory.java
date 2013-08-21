package com.kalyzee.jobsframework.services;

import java.util.Properties;

public class ServiceCoreFactory implements IServiceCoreFactory{

	private static IServiceCoreFactory instance;

	private ServiceCoreFactory(){
		
	}
	
	public static IServiceCoreFactory getInstance(){
		if (instance == null){
			instance = new ServiceCoreFactory();
		}
		return instance;
	}

	@Override
	public IService createServiceCore(Properties properties) throws ServiceException {
		ServiceCore serviceCore = new ServiceCore();
		serviceCore.init(properties);
		return serviceCore;
	}
	
}
