package com.zheng.my.shop.web.admin.service.Impl;

import com.zheng.my.shop.commons.dto.BaseResult;
import com.zheng.my.shop.commons.utils.RegexUtils;
import com.zheng.my.shop.domain.TbUser;
import com.zheng.my.shop.web.admin.dao.TbUserDao;
import com.zheng.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
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


    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult = checkResult(tbUser);

        // 检查成功 就进行用户编辑操作
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            tbUser.setUpdated(new Date());
            // 新增用户
            if (tbUser.getId() == null) {
                // 加密密码
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }

            //  编辑用户
            else {
                tbUserDao.update(tbUser);
            }

            baseResult.setMessage("保存用户信息成功");
        }
        return baseResult;
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
        return tbUserDao.selectByName(name);
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

    @Override
    public List<TbUser> search(String keyWord) {
        TbUser tbUser = new TbUser();

        tbUser.setUsername(keyWord);
        tbUser.setEmail(keyWord);
        tbUser.setPhone(keyWord);

        return tbUserDao.search(tbUser);
    }



    /**
     * 检查提交数据的合法性
     * @param tbUser
     */
    private BaseResult checkResult(TbUser tbUser) {
        BaseResult baseResult = BaseResult.success();

        if (StringUtils.isBlank(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不能为空");
        }
        else if (!RegexUtils.isEmail(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱格式错误");
        }

        else if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("  密码不能为空");
        }

        else if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = BaseResult.fail("姓名不能为空");
        }

        else if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = BaseResult.fail("号码不能为空");
        }

        else if (!RegexUtils.isMobile(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机格式不正确");
        }

        else if (isExist(tbUser)) {
            baseResult = BaseResult.fail("用户已经存在");
        }
        return baseResult;
    }

    /**
     * 判断用户是否已经存在
     * @param tbUser
     * @return [true 存在][false 不存在]
     */
    private boolean isExist(TbUser tbUser) {
        // 判断是否已经存在用户
        TbUser userByEmail = tbUserDao.getUserByEmail(tbUser.getEmail());
        if (userByEmail != null) {
            return true;
        }
        return false;
    }

}
