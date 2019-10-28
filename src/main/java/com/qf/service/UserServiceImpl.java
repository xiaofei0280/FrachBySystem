package com.qf.service;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserByName(String username) {
        User user = userDao.findByUsername(username);
        return user;
    }
}
