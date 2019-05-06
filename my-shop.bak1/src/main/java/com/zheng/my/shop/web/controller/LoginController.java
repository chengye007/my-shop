package com.zheng.my.shop.web.controller;

import com.zheng.my.shop.commons.constant.ConstantUtils;
import com.zheng.my.shop.entity.User;
import com.zheng.my.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    // 自动装配
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email,
                        @RequestParam(required = true) String password,
                        HttpServletRequest request) {
        User user = userService.login(email, password);

        if (user == null) {
            return login();
        }

        // login successful
        else {
            //   将登录信放入会话
            request.getSession().setAttribute(ConstantUtils.SESSION_USER, user);
            return "redirect:/main";
        }

    }
}
