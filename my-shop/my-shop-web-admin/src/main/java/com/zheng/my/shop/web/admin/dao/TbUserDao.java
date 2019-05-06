package com.zheng.my.shop.web.admin.dao;

import com.zheng.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *  We don't need to implement this interface.
 */
@Repository
public interface TbUserDao {
    /**
     * 查询所有用户信息
     * @return  返回用户信息链表
     */
    List<TbUser> selectAll();

    /**
     * insert a new user
     * @param user
     */
    void insert(TbUser user);

    /**
     * delete a user
     * @param user
     */
    void delete(TbUser user);

    /**
     * update a user information
     * @param user
     */
    void update(TbUser user);

    /**
     * get user by id
     * @param user
     */
    TbUser getById(TbUser user);

    /**
     * get user by name
     * @param user
     * @return
     */
    List<TbUser> selectByName(TbUser user);

    /**
     * get user entry by the email
     * @param email
     * @return user information or null
     */
    TbUser getUserByEmail(String email);
}
