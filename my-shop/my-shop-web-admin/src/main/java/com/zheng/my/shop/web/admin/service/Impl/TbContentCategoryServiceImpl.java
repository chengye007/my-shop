package com.zheng.my.shop.web.admin.service.Impl;

import com.zheng.my.shop.commons.dto.BaseResult;
import com.zheng.my.shop.domain.TbContentCategory;
import com.zheng.my.shop.web.admin.dao.TbContentCategoryDao;
import com.zheng.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        return tbContentCategoryDao.getById(id);
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

    /**
     * 保存 TbContentCategory 信息
     * @param tbContentCategory
     */
    public BaseResult save(TbContentCategory tbContentCategory) {
        BaseResult baseResult = ckeckContentCategory(tbContentCategory);
        // 检查成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            tbContentCategory.setUpdated(new Date());
            // 新增
            if (tbContentCategory.getId() == null) {
                tbContentCategory.setCreated(new Date());

                TbContentCategory parentEntry = tbContentCategoryDao.getById(tbContentCategory.getParentId());

                if (parentEntry.getIsParent() == false) {
                    parentEntry.setIsParent(true);
                    tbContentCategoryDao.update(parentEntry);
                }

                tbContentCategoryDao.insert(tbContentCategory);
            }

            //  编辑
            else {
                tbContentCategoryDao.update(tbContentCategory);
            }
            baseResult.setMessage("保存内容信息成功");
        }
        return baseResult;
    }

    public void delete(Long id) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(id);
        tbContentCategoryDao.delete(tbContentCategory);
    }

    /**
     * 检查 TbContentCategory 是否 符合要求
     * @param tbContentCategory
     * @return
     */
    private BaseResult ckeckContentCategory(TbContentCategory tbContentCategory) {
        return BaseResult.success();
    }
}
