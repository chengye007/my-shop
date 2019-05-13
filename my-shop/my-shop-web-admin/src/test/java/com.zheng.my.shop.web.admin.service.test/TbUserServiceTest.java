package com.zheng.my.shop.web.admin.service.test;

import com.zheng.my.shop.domain.TbUser;
import com.zheng.my.shop.web.admin.service.TbUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml",
        "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {

    @Autowired
    private TbUserService tbUserServices;


    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserServices.selectAll();

        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void insert() {
        TbUser user = new TbUser();
        user.setUsername("zheng");
        user.setPhone("18888888888");
        user.setEmail("1582090156@qq.com");
        user.setPassword(DigestUtils.md5DigestAsHex("123456789".getBytes()));
        user.setCreated(new Date());
        user.setUpdated(new Date());

        tbUserServices.save(user);
    }

    @Test
    public void delete() {
        tbUserServices.delete(36L);
    }

    @Test
    public void getById() {
        TbUser user = tbUserServices.getById(18L);
        System.out.println(user.toString());
    }

    @Test
    public void update() {
        TbUser findUser = tbUserServices.getById(51L);
        findUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUserServices.update(findUser);
        TbUser updateUser = tbUserServices.getById(51L);
        Assert.assertEquals(DigestUtils.md5DigestAsHex("123456".getBytes()), updateUser.getPassword());
    }

    @Test
    public void login() {
        TbUser userLogin = tbUserServices.login("1582090156@qq.com", "123456789");
        Assert.assertNotNull(userLogin);
    }
}
