package com.sdh.service.impl;

import com.sdh.dao.UserDao;
import com.sdh.pojo.User;
import com.sdh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/26 16:54
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }

}
