package com.zheng.my.shop.web.admin.web.controller;

import com.zheng.my.shop.commons.dto.BaseResult;
import com.zheng.my.shop.domain.TbContent;
import com.zheng.my.shop.domain.TbContentCategory;
import com.zheng.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容分类服务管理
 */

@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {

    @Autowired
    private TbContentCategoryService tbContentCategoryService;


    @ModelAttribute
    public TbContentCategory getTbContent(@RequestParam(required = false)Long id) {
        TbContentCategory contentCategory = null;

        if (id != null) {
            contentCategory = tbContentCategoryService.getById(id);

        }

        else {
            contentCategory = new TbContentCategory();
        }
        return contentCategory;
    }

    /**
     * 跳转到内容列表页面
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> tbContentCategories = tbContentCategoryService.selectAll();
        // 进行排序
        sortList(tbContentCategories, targetList, 0L);
        model.addAttribute("tbContentCategories", targetList);
        return "content_category_list";
    }

    /**
     * 获取树形数据
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tree/data", method = RequestMethod.GET)
    public List<TbContentCategory> treeData(Long id) {
        if (null == id)
            id = 0L;
        return tbContentCategoryService.selectByPid(id);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form() {
        return "content_category_form";
    }


    /**
     * 提交表单操作
     * @param tbContentCategory
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContentCategory tbContentCategory, Model model, RedirectAttributes redirectAttributes) {

        BaseResult baseResult = tbContentCategoryService.save(tbContentCategory);
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


    /*****************************private*****************************/
    /**
     * 排序
     * @param list 数据原集合
     * @param targetList 排序后的集合
     * @param parentId 父节点的Id
     */
    private void sortList(List<TbContentCategory> list, List<TbContentCategory> targetList, Long parentId) {
        for (TbContentCategory tbContentCategory : list) {
            if (tbContentCategory.getParentId().equals(parentId)) {
                targetList.add(tbContentCategory);

                // 该节点 是否是父节点
                if (tbContentCategory.getIsParent()) {
                    for (TbContentCategory contentCategory : list) {
                        if (contentCategory.getParentId().equals(tbContentCategory.getId())) {
                            sortList(list, targetList, tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }

        }
    }
}
