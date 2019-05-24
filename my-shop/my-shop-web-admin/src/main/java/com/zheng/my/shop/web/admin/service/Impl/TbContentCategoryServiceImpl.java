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

    private final TbContentCategoryDao tbContentCategoryDao;

    @Autowired
    public TbContentCategoryServiceImpl(TbContentCategoryDao tbContentCategoryDao) {
        this.tbContentCategoryDao = tbContentCategoryDao;
    }

    /**
     * 查询全部内容页
     * @return TbContentCategory list
     */
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }

    @Override
    public TbContentCategory getById(Long id) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(id);
        return tbContentCategoryDao.getById(tbContentCategory);
    }
    /**
     * 根据 pid 查询所有子节点
     * @param pid pid
     * @return TbContentCategory list
     */
    public List<TbContentCategory> selectByPid(Long pid) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setParentId(pid);
        return tbContentCategoryDao.selectByPid(tbContentCategory);
    }

}
