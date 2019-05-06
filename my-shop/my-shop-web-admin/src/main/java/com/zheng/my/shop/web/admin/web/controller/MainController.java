package com.zheng.my.shop.web.admin.web.controller;

import com.zheng.my.shop.domain.TbUser;
import com.zheng.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

}