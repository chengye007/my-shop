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
}
