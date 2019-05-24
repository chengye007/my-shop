package com.zheng.my.shop.web.admin.service.test;

import com.zheng.my.shop.commons.dto.BaseResult;
import com.zheng.my.shop.domain.TbContent;
import com.zheng.my.shop.web.admin.service.TbContentService;
import org.junit.Assert;
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

    @Test
    public void shouldSave() {
        TbContent tbContent = new TbContent();
        tbContent.setCategoryId(89L);
        tbContent.setTitle("a");
        tbContent.setSubTitle("a");
        tbContent.setTitleDesc("a");
        tbContent.setUrl("a");
        tbContent.setPic("a");
        tbContent.setPic2("a");
        tbContent.setContent("a");

        BaseResult saveResult = tbContentService.save(tbContent);
        Assert.assertEquals(BaseResult.STATUS_SUCCESS, saveResult.getStatus());
    }

    @Test
    public void shouldDelete() {
        tbContentService.delete(33L);
        TbContent content = tbContentService.getById(33L);
        Assert.assertNull(content);
    }
}
