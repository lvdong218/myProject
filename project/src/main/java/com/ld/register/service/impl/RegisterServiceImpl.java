package com.ld.register.service.impl;

import com.ld.register.bean.User;
import com.ld.register.dao.RegisterDao;
import com.ld.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterDao registerDao;

    @Override
    public void insert(User user) {
        registerDao.insert(user);
    }

}
