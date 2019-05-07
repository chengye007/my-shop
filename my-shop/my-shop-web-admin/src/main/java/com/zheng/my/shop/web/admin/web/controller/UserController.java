package com.zheng.my.shop.web.admin.web.controller;

import com.zheng.my.shop.commons.dto.BaseResult;
import com.zheng.my.shop.domain.TbUser;
import com.zheng.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * user controller
 */

@Controller
@RequestMapping(value = "user")    // /user/list
public class UserController {

    @Autowired
    private TbUserService tbUserService;

    @ModelAttribute
    public TbUser getTbUser(@RequestParam(required = false)Long id) {
        TbUser tbUser = null;

        if (id != null) {
            tbUser = tbUserService.getById(id);
        }

        else {
            tbUser = new TbUser();
        }

        return tbUser;
    }


    /**
     * 跳转到用户列表页
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }

    /**
     * 跳转到用户表单页面
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "user_form";
    }

    /**
     * 提交表单操作
     * @param tbUser
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes) {

        BaseResult baseResult = tbUserService.save(tbUser);
        // 保存成功进行重定向
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
           redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        }

        // 保存失败 进行跳转
        else {
            model.addAttribute("baseResult", baseResult);
            return "user_form";
        }
    }
}
