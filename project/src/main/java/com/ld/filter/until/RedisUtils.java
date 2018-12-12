package com.ld.filter.until;

import redis.clients.jedis.Jedis;

public class RedisUtils {
	/**
	 * 设置String类型的值
	 * @param key
	 * @param value
	 */
	public void setString(String key,String value) {
		Jedis jedis=RedisPoolUtils.getJedis();
		
		jedis.set(key, value);
		jedis.close();
	}
	public void setEx(String key,int seconds,String value) {
		Jedis jedis=RedisPoolUtils.getJedis();
		jedis.setex(key, seconds, value);
		jedis.set(key, value);
		jedis.close();
	}
	
	public Boolean exit(String key) {
		Jedis jedis=RedisPoolUtils.getJedis();
		boolean b=jedis.exists(key);
		jedis.close();
		return b; 
	}
	/**
	 * 获取string
	 * @param key
	 */
	public String getString(String key) {
		String str=null;
		Jedis jedis=RedisPoolUtils.getJedis();
		
		str=jedis.get(key);
		jedis.close();
		return str;
	}
	/**
	 * 根据key设置超时时间，秒为单位
	 * @param key
	 * @param seconds
	 */
	public void expire(String key,int seconds) {
		Jedis jedis=RedisPoolUtils.getJedis();
		
		jedis.expire(key,seconds);
		jedis.close();
	}
	/**
	 * 批量删除key
	 * @param keys
	 * @return
	 */
	public Long del(String...keys) {
		Jedis jedis=RedisPoolUtils.getJedis();
		
		long count=jedis.del(keys);
		jedis.close();
		return count;
	}
	/**
	 * 清空所有key
	 */
	public void flushAll() {
		Jedis jedis=RedisPoolUtils.getJedis();
		
		jedis.flushAll();
		jedis.close();
	}
	/**
	 * 取消对key过期时间的设置
	 */
	public void persist(String key) {
		Jedis jedis=RedisPoolUtils.getJedis();
		
		jedis.persist(key);
		jedis.close();
	}
}
