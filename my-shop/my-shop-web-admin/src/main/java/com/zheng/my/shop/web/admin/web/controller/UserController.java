package com.zheng.my.shop.web.admin.web.controller;

import com.zheng.my.shop.commons.dto.BaseResult;
import com.zheng.my.shop.domain.TbUser;
import com.zheng.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    /**
     * 模糊查询 关键字为 邮箱 姓名 或者 电话
     * @param tbUser
     * @param model
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(TbUser tbUser, Model model) {
        List<TbUser> tbUsers = tbUserService.search(tbUser);
        model.addAttribute("tbUsers", tbUsers);
        return "user_list";
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;

        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            tbUserService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除数据成功");
        }

        else {
            baseResult.fail("删除数据失败");
        }
//        System.out.println(ids);
        return baseResult;
    }
}
