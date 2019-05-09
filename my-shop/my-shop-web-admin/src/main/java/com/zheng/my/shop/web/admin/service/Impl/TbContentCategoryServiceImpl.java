package com.zheng.my.shop.web.admin.service.Impl;

import com.zheng.my.shop.domain.TbContentCategory;
import com.zheng.my.shop.web.admin.dao.TbContentCategoryDao;
import com.zheng.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容分类服务接口实现
 */

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;

    /**
     * 查询全部内容页
     * @return
     */
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }

}
