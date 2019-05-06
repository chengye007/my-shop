package com.zheng.my.shop.dao.Impl;

import com.zheng.my.shop.dao.UserDao;
import com.zheng.my.shop.entity.User;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    public User getUser(String email, String password) {
        User user = null;

        if ("admin@qq.com".equals(email)) {
            if ("admin".equals(password)) {
                user = new User();
                user.setUserEmail("admin@qq.com");
                user.setUserName("zheng");
            }
        }
        return user;
    }
}
