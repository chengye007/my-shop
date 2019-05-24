package com.zheng.my.shop.web.admin.dao;

import com.zheng.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao {
    /**
     * 查询全部内容
     * @return
     */
    List<TbContentCategory> selectAll();

    /**
     * 根据 Id 查询 TbContentCategory
     * @param
     * @return
     */
    TbContentCategory getById(TbContentCategory tbContentCategory);

    /**
     * 根据 pid 查询内容
     * @param
     * @return
     */
    List<TbContentCategory> selectByPid(TbContentCategory tbContentCategory);
}
