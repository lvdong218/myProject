package com.ld.util;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import net.sf.json.JSONObject;

public class TestUtils {
	@Test
	public void run () {
		JSONObject param=new JSONObject();
		param.put("param1", 1);
		param.put("param2", 2);
		String resultStr=param.toString();
		JSONObject json=JSONObject.fromObject(resultStr);
		System.out.println(json);
//		Mytask mytask=new Mytask(1000,"第一个");
//		Mytask mytask1=new Mytask(1000,"第二个");
//		Mytask mytask2=new Mytask(0,"第三个");
//		Mytask mytask3=new Mytask(0,"第四个");
//		Mytask mytask4=new Mytask(0,"第五个");
//		Mytask mytask5=new Mytask(0,"第六个");
//		Mytask mytask6=new Mytask(0,"第Ⅶ个");
//		Mytask mytask7=new Mytask(0,"第Ⅷ个");
//		ScheduledThreadPoolExecutor pool=new ScheduledThreadPoolExecutor(5);
//		ThreadPoolUtils.setPool(pool);
//		ThreadPoolUtils.schedule(mytask);
//		ThreadPoolUtils.schedule(mytask1);
//		ThreadPoolUtils.schedule(mytask2);
//		ThreadPoolUtils.schedule(mytask3);
//		ThreadPoolUtils.schedule(mytask4);
//		ThreadPoolUtils.schedule(mytask5);
//		ThreadPoolUtils.schedule(mytask6);
	}
	public static void main(String[] args) {
		Mytask mytask=new Mytask(1000,"第一个");
		Mytask mytask1=new Mytask(1000,"第二个");
		Mytask mytask2=new Mytask(0,"第三个");
		Mytask mytask3=new Mytask(0,"第四个");
		Mytask mytask4=new Mytask(0,"第五个");
		Mytask mytask5=new Mytask(0,"第六个");
		Mytask mytask6=new Mytask(0,"第Ⅶ个");
		Mytask mytask7=new Mytask(0,"第Ⅷ个");
		ScheduledThreadPoolExecutor pool=new ScheduledThreadPoolExecutor(5);
		ThreadPoolUtils.setPool(pool);
		ThreadPoolUtils.schedule(mytask);
		ThreadPoolUtils.schedule(mytask1);
		ThreadPoolUtils.schedule(mytask2);
		ThreadPoolUtils.schedule(mytask3);
		ThreadPoolUtils.schedule(mytask4);
		ThreadPoolUtils.schedule(mytask5);
		ThreadPoolUtils.schedule(mytask6);
	}
	private static class Mytask implements Runnable{
		int sleepTime;
		String comment;
		public Mytask(int sleepTime,String comment) {
			this.sleepTime=sleepTime;
			this.comment=comment;
		}
		@Override
		public void run() {
				System.out.println(comment);
			
			
		}
		
	}
}
