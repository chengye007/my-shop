package com.zheng.my.shop.web.admin.service;

import com.zheng.my.shop.commons.dto.BaseResult;
import com.zheng.my.shop.domain.TbContent;

import java.util.List;

public interface TbContentService {
    List<TbContent> selectAll();

    BaseResult save(TbContent content);

    void delete(Long id);

    void update(TbContent content);

    TbContent getById(Long id);

    void deleteMulti(String[] ids);

    List<TbContent> search(TbContent tbContent);
}
