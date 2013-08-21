package com.kalyzee.jobsframework.services;

import java.util.Properties;

public interface IService {
	void init(Properties prop) throws ServiceException;
	void close() throws ServiceException;
}
