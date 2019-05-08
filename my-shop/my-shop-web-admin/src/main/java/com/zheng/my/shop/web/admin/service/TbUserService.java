package com.zheng.my.shop.web.admin.service;

import com.zheng.my.shop.commons.dto.BaseResult;
import com.zheng.my.shop.domain.TbUser;
import java.util.List;

public interface TbUserService {

    /**
     * 查询全部用户信息
     * @return  用户信息链表
     */
    List<TbUser> selectAll();

    /**
     * 保存 或者 添加 用户信息
     * @param tbUser
     * @return
     */
    BaseResult save(TbUser tbUser);

    /**
     * 根据 id 删除用户信息
     * @param id
     */
    void delete(long id);

    /**
     * 更新指定用户信息
     * @param user
     */
    void update(TbUser user);

    /**
     * 根据 ID 获取用户信息
     * @param id
     * @return
     */
    TbUser getById(long id);

    /**
     * 登录方法
     * @param email
     * @param password
     * @return 返回用户信息，不存在返回 null
     */
    TbUser login(String email, String password);

    /**
     * 按邮箱、手机号码 和 姓名进行查找
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);

    /**
     * 批量删除 ids 中符合条件的 user 信息
     * @param ids
     */
    void deleteMulti(String[] ids);
}
