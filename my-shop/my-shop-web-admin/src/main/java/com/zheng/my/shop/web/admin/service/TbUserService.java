package com.zheng.my.shop.web.admin.service;

import com.zheng.my.shop.commons.dto.BaseResult;
import com.zheng.my.shop.domain.TbUser;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TbUserService {
    List<TbUser> selectAll();

    BaseResult save(TbUser tbUser);

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

    /**
     * 按邮箱、手机号码 和 姓名进行查找
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);

    /**
     * 删除ids中的信息
     * @param ids
     */
    void deleteMulti(String[] ids);
}
