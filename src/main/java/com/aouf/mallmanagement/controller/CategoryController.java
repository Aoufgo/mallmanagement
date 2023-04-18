package com.aouf.mallmanagement.controller;

import com.aouf.mallmanagement.bean.bo.SearchCategoryBo;
import com.aouf.mallmanagement.bean.po.Category;
import com.aouf.mallmanagement.service.ICategoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private ICategoryService categoryService;
    @Autowired
    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/admin")
    public String admin(Model model, SearchCategoryBo searchCategoryBo){
        PageInfo<Category> catePageInfo = categoryService.getCategoriesByBo(searchCategoryBo);
        model.addAttribute("categories",catePageInfo.getList());
        model.addAttribute("parents",categoryService.getAllParentCategories());
        model.addAttribute("searchCategoryBo",searchCategoryBo);
        model.addAttribute("pageCount", catePageInfo.getPages());
        model.addAttribute("page",searchCategoryBo.getPage());
        model.addAttribute("pageSize",searchCategoryBo.getPageSize());
        return "/category/list";
    }

}
