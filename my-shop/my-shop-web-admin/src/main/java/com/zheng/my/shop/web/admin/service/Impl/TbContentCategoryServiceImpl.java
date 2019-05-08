package com.zheng.my.shop.web.admin.service.Impl;

import com.zheng.my.shop.web.admin.dao.TbContentCategoryDao;
import com.zheng.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 内容分类服务接口实现
 */

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;
}
