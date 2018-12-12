package com.ld.login.service;

import java.util.Map;

import com.ld.login.Bean.User;

/**
 * LoginService接口，定义一些增删改查用户信息的方法
 * @author lvdong
 *
 */
public interface LoginService {
	/**
	 * 根据登录名和密码查询出用户信息并返回
	 * @param user
	 * @return
	 */
	public User queryByInfo(User user);
	/**
	 * 根据名称获取是否在当前数据库中存在
	 * @param map
	 * @return
	 */
	public User queryByName(User user);
}
