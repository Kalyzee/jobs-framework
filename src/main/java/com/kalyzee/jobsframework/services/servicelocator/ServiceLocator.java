package com.kalyzee.jobsframework.services.servicelocator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator implements IServiceLocator{
	private static IServiceLocator instance;
	
	private Context ctx;
	
	private ServiceLocator() throws ServiceLocatorException{
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			throw new ServiceLocatorException(e.getMessage());
		}
		
	}
	
	@Override
	public void createSubContext(String subcontext) throws ServiceLocatorException{
		try {
			ctx.createSubcontext(subcontext);
		} catch (NamingException e) {
			throw new ServiceLocatorException(e.getMessage());
		}
	}

	@Override
	public void bind(String name, Object object) throws ServiceLocatorException {
		try {
			ctx.bind(name, object);
		} catch (NamingException e) {
			throw new ServiceLocatorException(e.getMessage());
		}
	}



	@Override
	public Object lookup(String name) throws ServiceLocatorException {
		try {
			return ctx.lookup(name);
		} catch (NamingException e) {
			throw new ServiceLocatorException(e.getMessage());
		}
	}
	
	public static IServiceLocator getInstance() throws ServiceLocatorException{
		if (instance == null){
			instance = new ServiceLocator();
		}
		return instance;
	}

	@Override
	public void close() throws ServiceLocatorException {
		try {
			ctx.close();
		} catch (NamingException e) {
			throw new ServiceLocatorException(e.getMessage()); 
		}
		
	}
}
