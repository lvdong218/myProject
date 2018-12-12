package com.ld.filter.until;

import org.redisson.Redisson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public final class RedisPoolUtils {
	//服务器地址
	private static String IP="127.0.0.1";
	//reids端口
	private static int PORT=6379;
	//权限认证
	private static String AUTH="test";
	//最大连接数
	private static int MAX_TOTAL=20000;
	//最大空闲连接数
	private static int MAX_IDLE=3000;
	//等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超时，则抛出
	private static int MAX_WAIT=10000;
	//超时时间
	private static int TIMEOUT=1000*60*60*3;
	//在borrow一个jedis实例时，是否提前进行validate操作：如为true则得到的jedis实例均可用
	private static boolean TEST_ON_BORROW=true;
	//连接池
	private static JedisPool jedisPool=null;
	//初始化
	static {
		JedisPoolConfig config=new JedisPoolConfig();
		config.setMaxTotal(MAX_TOTAL);
		config.setMaxIdle(MAX_IDLE);
		config.setMaxWaitMillis(MAX_WAIT);
		config.setTestOnBorrow(TEST_ON_BORROW);
		jedisPool=new JedisPool(config,IP,PORT);
	}
	
	public synchronized static Jedis getJedis() {
		try {
			if(jedisPool!=null) {
				return jedisPool.getResource();
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
