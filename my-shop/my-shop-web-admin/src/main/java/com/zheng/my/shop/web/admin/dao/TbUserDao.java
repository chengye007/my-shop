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
     * 添加新用户
     * @param user
     */
    void insert(TbUser user);

    /**
     * 删除一条用户信息
     * @param user
     */
    void delete(TbUser user);

    /**
     * 更新一条用户信息
     * @param user
     */
    void update(TbUser user);

    /**
     * 根据 ID 查询用户信息
     * @param user
     */
    TbUser getById(TbUser user);


    /**
     * 根据 email 查询用户信息
     * @param email
     * @return 有信息返回 TbUser 对象， 否则返回 null
     */
    TbUser getUserByEmail(String email);

    /**
     * 按邮箱、姓名 或者 手机号查询
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);

    /**
     * 删除符合数组在数组 ids 中的全部用户信息
     * @param ids
     */
    void deleteMulti(String[] ids);
}
