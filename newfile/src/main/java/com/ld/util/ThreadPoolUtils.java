package com.ld.util;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 线程池工具类
 * @author lvdong
 *
 */
public class ThreadPoolUtils {
	//线程池
	private static ScheduledThreadPoolExecutor pool;
	
	public static ScheduledThreadPoolExecutor getPool() {
		return pool;
	}
	public static void setPool(ScheduledThreadPoolExecutor pool) {
		ThreadPoolUtils.pool = pool;
	}
	/**
	 * 初始化
	 */
	public ThreadPoolUtils() {
	    pool=new ScheduledThreadPoolExecutor(5);
	}
	/**
	 * 执行方法
	 * @param command
	 */
	public static void schedule(Runnable command) {
		pool.schedule(command, 0, TimeUnit.SECONDS);
	}
}
