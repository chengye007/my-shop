package com.zheng.my.shop.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbContentCategory implements Serializable {
    private Long    id;
    private Long    parentId;
    private String  name;
    private int     status;
    private int     sortOrder;
    private Boolean isParent;
    private Date    created;
    private Date    updated;

    private TbContentCategory parent;
}
