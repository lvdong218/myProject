package com.ld.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * ServletContextListener需要在web.xml中进行配置
 * httpservlet也需要在web.xml中进行配置
 * @author lvdong
 *
 */
public class StartUpServlet implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("项目启动ServletContextListener");
		Runnable runnable = new Runnable() {  
            public void run() {  
            	System.out.println("111");
            }  
        };  
        ScheduledExecutorService service = Executors  
                .newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 0, 30, TimeUnit.SECONDS);
//		InitProjectThread thread=new InitProjectThread();
//		new Thread(thread).start();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
}
class InitProjectThread implements Runnable {
	@Override
	public void run() {
		//启动执行方法
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0;i<1000;i++) {
			if(i==999) {
				System.out.println("执行项目启动线程");
			}
		}
	}
	
}
