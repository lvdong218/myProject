package com.ld.register.dao;

import com.ld.register.bean.User;
import org.springframework.stereotype.Repository;


@Repository("registerDao")
public interface RegisterDao {
	public void insert(User user);
}
