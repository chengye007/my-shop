package com.zheng.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbUser implements Serializable {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date updated;
}
