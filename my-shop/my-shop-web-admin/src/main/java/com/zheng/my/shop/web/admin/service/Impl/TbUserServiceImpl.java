package com.zheng.my.shop.web.admin.service.Impl;

import com.zheng.my.shop.domain.TbUser;
import com.zheng.my.shop.web.admin.dao.TbUserDao;
import com.zheng.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    /**
     * 检查提交数据的合法性
     * @param tbUser
     */
    private void check(TbUser tbUser) {

    }

    @Override
    public void save(TbUser tbUser) {
        tbUser.setUpdated(new Date());

        // 新增用户
        if (tbUser.getId() == null) {
            tbUser.setCreated(new Date());
            tbUserDao.insert(tbUser);
        }

        //  编辑用户
        else {
            tbUserDao.update(tbUser);
        }
    }

    @Override
    public void delete(long id) {
        TbUser user = new TbUser();
        user.setId(id);
        tbUserDao.delete(user);
    }

    @Override
    public void update(TbUser user) {
        tbUserDao.update(user);
    }

    @Override
    public TbUser getById(long id) {
        TbUser user = new TbUser();
        user.setId(id);
        return tbUserDao.getById(user);
    }

    @Override
    public List<TbUser> selectByName(String name) {
        TbUser user = new TbUser();
        user.setUsername(name);
        return tbUserDao.selectByName(user);
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser userByEmail = tbUserDao.getUserByEmail(email);
        if (userByEmail != null) {
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

            if (userByEmail.getPassword().equals(md5Password)) {
                return userByEmail;
            }
        }

        return null;
    }


}
