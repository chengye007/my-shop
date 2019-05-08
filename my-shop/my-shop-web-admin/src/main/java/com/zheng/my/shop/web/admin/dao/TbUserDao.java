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
     * @param username
     * @return
     */
    List<TbUser> selectByName(String username);

    /**
     * get user entry by the email
     * @param email
     * @return user information or null
     */
    TbUser getUserByEmail(String email);

    /**
     * 按邮箱、姓名 或者 手机号查询
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);

    /**
     * 删除符合数组 id 的信息
     * @param ids
     */
    void deleteMulti(String[] ids);
}
