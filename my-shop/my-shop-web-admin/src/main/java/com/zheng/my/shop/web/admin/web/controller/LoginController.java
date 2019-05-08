package com.zheng.my.shop.web.admin.web.controller;

import com.zheng.my.shop.domain.TbUser;
import com.zheng.my.shop.domain.User;
import com.zheng.my.shop.web.admin.commons.constant.ConstantUtils;
import com.zheng.my.shop.web.admin.commons.utils.CookieUtils;
import com.zheng.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {

    // 自动装配
    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
//        String userInfo = CookieUtils.getCookieValue(request, response, ConstantUtils.COOKIE_USER_INFO);
//        if (userInfo != null) {
//            String[] arr = userInfo.split(":");
//            if (arr.length >= 2) {
//                String email = arr[0];
//                String password = arr[1];
//
//                request.getSession().setAttribute("email", email);
//                request.getSession().setAttribute("password", password);
//                request.getSession().setAttribute("isRemember", true);
//            }
//        }
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email,
                        @RequestParam(required = true) String password,
                        @RequestParam(required = false) String isRemember,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        Model model) {
        TbUser loginUser = tbUserService.login(email, password);

        // login unsuccessful
        if (loginUser == null) {
            model.addAttribute("message", "username or password error");
            return login();
        }

        // login unsuccessful
        else {
            // put the login information into the session
            request.getSession().setAttribute(ConstantUtils.SESSION_USER, loginUser);
            return "redirect:/main";
        }
    }

    /**
     * logout
     * @return page url without prefix and suffix
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        System.out.println("logout");
        // clean the session content and redirect login page
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
