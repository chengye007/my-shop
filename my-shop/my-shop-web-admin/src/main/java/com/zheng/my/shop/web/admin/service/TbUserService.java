package com.zheng.my.shop.web.admin.service;

import com.zheng.my.shop.domain.TbUser;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TbUserService {
    List<TbUser> selectAll();

    void save(TbUser tbUser);

    void delete(long id);

    void update(TbUser user);

    TbUser getById(long id);

    List<TbUser> selectByName(String name);

    /**
     * login function
     * @param email email
     * @param password password
     * @return user information or null
     */
    TbUser login(String email, String password);
}
