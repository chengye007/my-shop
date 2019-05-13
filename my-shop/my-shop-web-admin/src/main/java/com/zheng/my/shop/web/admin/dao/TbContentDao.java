package com.zheng.my.shop.web.admin.dao;

import com.zheng.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentDao {
    List<TbContent> selectAll();

    void insert(TbContent content);

    void delete(TbContent content);

    void update(TbContent content);

    TbContent getById(TbContent content);

    List<TbContent> search(TbContent content);

    void deleteMulti(String[] ids);
}
