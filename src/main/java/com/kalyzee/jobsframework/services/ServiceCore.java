package com.kalyzee.jobsframework.services;

import java.util.Properties;

import com.kalyzee.jobsframework.core.JobFrameworkCoreFactory;
import com.kalyzee.jobsframework.services.servicelocator.IServiceLocator;
import com.kalyzee.jobsframework.services.servicelocator.ServiceLocatorException;
import com.kalyzee.jobsframework.services.servicelocator.ServiceLocatorFactory;

public class ServiceCore implements IService{
	private IServiceLocator context;
	
	@Override
	public void init(Properties properties) throws ServiceException {
		try {
			context = ServiceLocatorFactory.getInstance().getServiceLocator();
			context.createSubContext("jobsframework");
			context.bind("jobsframework/framework_core_factory", JobFrameworkCoreFactory.getInstance());
			context.bind("jobsframework/messenger_service", initService(MessengerService.class, properties));			
		}  catch (ServiceLocatorException e) {
			throw new ServiceException(e.getMessage());

		}
	}
	
	
	private IService initService(Class<?> serviceClass, Properties properties) throws ServiceException{
		if (IService.class.isAssignableFrom(serviceClass)){
			IService service;
			try {
				service = (IService) serviceClass.newInstance();
				service.init(properties);
				return service;
			} catch (InstantiationException e) {
				throw new ServiceException(e.getMessage());
			} catch (IllegalAccessException e) {
				throw new ServiceException(e.getMessage());
			} catch (ServiceException e) {
				throw new ServiceException(e.getMessage());
			}

		}
		throw new ServiceException("Can't instantiate service "+serviceClass.toString());
		
	}
	
	@Override
	public void close() throws ServiceException {

		
	}
	
}
