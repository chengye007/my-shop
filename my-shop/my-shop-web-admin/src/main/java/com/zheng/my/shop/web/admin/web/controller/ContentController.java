package com.zheng.my.shop.web.admin.web.controller;


import com.zheng.my.shop.commons.dto.BaseResult;
import com.zheng.my.shop.domain.TbContent;
import com.zheng.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "content")
public class ContentController {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(@RequestParam(required = false)Long id) {
        TbContent content = null;

        if (id != null) {
            content = tbContentService.getById(id);
        }

        else {
            content = new TbContent();
        }

//        System.out.println(content.getTbContentCategory().getName());
        return content;
    }


    /**
     * 跳转到内容列表页
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContent> tbContents = tbContentService.selectAll();
        model.addAttribute("tbContents", tbContents);
        return "content_list";
    }

    /**
     * 跳转到内容表单页面
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "content_form";
    }

    /**
     * 提交表单操作
     * @param tbContent
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes) {

        BaseResult baseResult = tbContentService.save(tbContent);
        // 保存成功进行重定向
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/list";
        }

        // 保存失败 进行跳转
        else {
            model.addAttribute("baseResult", baseResult);
            return "content_form";
        }
    }

    /**
     * 模糊查询 关键字为 邮箱 姓名 或者 电话
     * @param tbContent
     * @param model
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(TbContent tbContent, Model model) {
        List<TbContent> tbContents = tbContentService.search(tbContent);
        model.addAttribute("tbContents", tbContents);
        return "content_list";
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;

        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            tbContentService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除数据成功");
        }

        else {
            baseResult = BaseResult.fail("删除数据失败");
        }
        return baseResult;
    }

    /**
     * 显示用户详情
     * @param tbContent
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(TbContent tbContent) {
        return "content_detail";
    }

}
