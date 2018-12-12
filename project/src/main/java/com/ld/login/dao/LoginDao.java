package com.ld.login.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ld.login.Bean.User;
/**
 * LoginDao的dao层
 * @author lvdong
 *
 */
@Repository("loginDao")
public interface LoginDao {
	public User queryByInfo(Map map);
	public User queryByName(Map map);
}
