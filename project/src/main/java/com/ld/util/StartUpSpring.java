package com.ld.util;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
@Service
public class StartUpSpring implements ApplicationListener<ContextRefreshedEvent>{
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		//web项目中（springmvc），系统会存在两个容器，一个是root application context
		//另一个就是我们自己的projectName-servlet context(作为root application context的子容器)
		//这种情况下就会造成onApplicationEvent方法被执行两次，为了避免这个问题我们可以只在root application context初始化
		//完成之后调用逻辑代码，其他容器初始化不进行任何处理
		if(arg0.getApplicationContext().getParent()==null) {
			//此处为spring项目启动执行的代码
			System.out.println("spring application 项目启动执行代码");
		}
	}
}
