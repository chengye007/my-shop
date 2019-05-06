package com.zheng.my.shop.service.Impl;

import com.zheng.my.shop.commons.context.SpringContext;
import com.zheng.my.shop.dao.UserDao;
import com.zheng.my.shop.entity.User;
import com.zheng.my.shop.service.UserService;
import org.springframework.stereotype.Service;


@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao = SpringContext.getBean("userDao");

    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
