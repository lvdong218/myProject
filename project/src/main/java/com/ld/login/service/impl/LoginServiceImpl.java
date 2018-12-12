package com.ld.login.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ld.login.Bean.User;
import com.ld.login.dao.LoginDao;
import com.ld.login.service.LoginService;

@Service
/**
 * LoginService接口的具体实现类
 * @author lvdong
 *
 */
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDao loginDao;
	@Transactional
	public User queryByInfo(User user) {
		Map map=new HashMap();
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		User loginUser=loginDao.queryByInfo(map);
		tran(map,loginUser);
		return loginUser;
	}
	public User queryByName(User user) {
		Map map=new HashMap();
		map.put("username", user.getUsername());
		User loginUser=loginDao.queryByName(map);
		return loginUser;
	}
	public String tran(Object...val) {
		return "";
	}
}
