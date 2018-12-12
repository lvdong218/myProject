package com.ld.register.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ld.register.bean.User;
import com.ld.register.dao.UserDao;
import com.ld.register.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}
	
}
