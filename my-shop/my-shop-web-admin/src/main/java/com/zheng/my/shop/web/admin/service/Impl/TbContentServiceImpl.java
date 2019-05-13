package com.zheng.my.shop.web.admin.service.Impl;

import com.zheng.my.shop.commons.dto.BaseResult;
import com.zheng.my.shop.domain.TbContent;
import com.zheng.my.shop.web.admin.dao.TbContentDao;

import com.zheng.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;

    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }

    public BaseResult save(TbContent content) {
        BaseResult baseResult = checkResult(content);
        // 检查成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            content.setUpdated(new Date());
            // 新增
            if (content.getId() == null) {
                content.setCreated(new Date());
                tbContentDao.insert(content);
            }

            //  编辑
            else {
                tbContentDao.update(content);
            }
            baseResult.setMessage("保存内容信息成功");
        }
        return baseResult;
    }

    public void delete(Long id) {
        TbContent content = new TbContent();
        content.setId(id);
        tbContentDao.delete(content);
    }

    public void update(TbContent content) {
        tbContentDao.update(content);
    }

    public TbContent getById(Long id) {
        TbContent content = new TbContent();
        content.setId(id);
        return tbContentDao.getById(content);
    }

    public void deleteMulti(String[] ids) {
        tbContentDao.deleteMulti(ids);
    }

    public List<TbContent> search(TbContent tbContent) {
        return tbContentDao.search(tbContent);
    }

    /*******************私有函数*******************/
    /**
     * 检查提交数据的合法性
     * @param tbContent
     */
    private BaseResult checkResult(TbContent tbContent) {
        BaseResult baseResult = BaseResult.success();

        if (tbContent.getCategoryId() == null) {
            baseResult = BaseResult.fail("CategoryId(内容的所属分类) 不能为空");
        }
        else if (StringUtils.isBlank(tbContent.getTitle())) {
            baseResult = BaseResult.fail("Title(标题) 不能为空");
        }

        else if (StringUtils.isBlank(tbContent.getSubTitle())) {
            baseResult = BaseResult.fail("subTitle 不能为空");
        }

        else if (StringUtils.isBlank(tbContent.getTitleDesc())) {
            baseResult = BaseResult.fail("titleDesc 不能为空");
        }

        else if (StringUtils.isBlank(tbContent.getUrl())) {
            baseResult = BaseResult.fail("url 不能为空");
        }

        else if (StringUtils.isBlank(tbContent.getPic())) {
            baseResult = BaseResult.fail("pic 不能为空");
        }

        else if (StringUtils.isBlank(tbContent.getPic2())) {
            baseResult = BaseResult.fail("pic2 不能为空");
        }

        else if (StringUtils.isBlank(tbContent.getContent())) {
            baseResult = BaseResult.fail("content 不能为空");
        }

        return baseResult;
    }

}
