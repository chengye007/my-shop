package com.zheng.my.shop.dao;

import com.zheng.my.shop.entity.User;

public interface UserDao {
    /**
     * get user information by email and password
     * @param email email
     * @param password  password
     * @return user
     */
    public User getUser(String email, String password);
}
