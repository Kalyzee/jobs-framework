package com.kalyzee.jobsframework.core;

import java.util.Properties;

public interface IJobFrameworkCoreFactory {
	
	public IFrameworkCore createJobFrameworkCore(String server, String queue);
	public IFrameworkCore createJobFrameworkCore(String server, String queue, String username, String password);

	public void init(Properties properties) throws JobsFrameworkCoreException;
}
