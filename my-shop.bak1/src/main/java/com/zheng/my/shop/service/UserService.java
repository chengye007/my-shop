package com.zheng.my.shop.service;

import com.zheng.my.shop.entity.User;

public interface UserService {
    /**
     * login by email and password
     * @param email
     * @param password
     * @return
     */
    public User login(String email, String password);
}
