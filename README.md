Kalyzee Jobs Framework

Create an application using Kalyzee jobs-framework

```
package com.kalyzee.jobsframework.demo.client;

import java.util.Properties;

import javax.jms.Message;

import com.kalyzee.jobsframework.core.IFrameworkCore;
import com.kalyzee.jobsframework.core.IJobCoreListener;
import com.kalyzee.jobsframework.core.IJobFrameworkCoreFactory;
import com.kalyzee.jobsframework.core.JobFrameworkCoreFactory;
import com.kalyzee.jobsframework.core.JobsFrameworkCoreException;
import com.kalyzee.jobsframework.services.IService;
import com.kalyzee.jobsframework.services.ServiceCore;
import com.kalyzee.jobsframework.services.ServiceCoreFactory;
import com.kalyzee.jobsframework.services.ServiceException;

public class DemoClient {

    /**
     * Demo client using Kalyzee Jobs Framework
     * @throws ServiceException 
     */
    public static void main(String[] args) throws ServiceException {
        Properties properties = new Properties();
        properties.setProperty("messenger.url", "tcp://localhost:61616");
        try {
            IJobFrameworkCoreFactory job  = JobFrameworkCoreFactory.getInstance();
            job.init(properties);
            IFrameworkCore frameworkCore = job.createJobFrameworkCore("tcp://localhost:61616","test");
            JobListener jl = new JobListener();
            frameworkCore.addJobListener(jl);
            frameworkCore.start();

        } catch (JobsFrameworkCoreException e) {
            e.printStackTrace();
        }

    }
}

class JobListener implements IJobCoreListener{

    @Override
    public void onNewJob(Message message) {
        System.out.println("Nouveau job detecté !");

    }

}
```

Using Service Locator everywhere 

```
ServiceLocator.getInstance().lookup("nom-du-service")
```

```
        messenger = (IMessengerService) ServiceLocator.getInstance().lookup("jobsframework/messenger_service");
        try {
            messenger.sendTopicMessage(serverUrl, "activpik/eucalyptus/"+jobType+"-"+event, properties);
        } catch (MessengerException e) {
            logger.severe("Can't send message to server");
        }
```

