package com.ld.register.dao;

import org.springframework.stereotype.Repository;

import com.ld.register.bean.User;

@Repository("userDao")
public interface UserDao {
	public void insert(User user);
}
