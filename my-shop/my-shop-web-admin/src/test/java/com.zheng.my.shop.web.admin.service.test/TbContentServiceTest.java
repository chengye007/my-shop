package com.zheng.my.shop.web.admin.service.test;

import com.zheng.my.shop.domain.TbContent;
import com.zheng.my.shop.web.admin.service.TbContentService;
import com.zheng.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml",
        "classpath:spring-context-mybatis.xml"})
public class TbContentServiceTest {

    @Autowired
    private TbContentService tbContentService;

    @Test
    public void shouldSelectAll() {
        List<TbContent> tbContents = tbContentService.selectAll();

        for (TbContent tbContent : tbContents) {
            System.out.println(tbContent);
        }
    }
}
