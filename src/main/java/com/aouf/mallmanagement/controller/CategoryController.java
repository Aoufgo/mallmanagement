package com.aouf.mallmanagement.controller;

import com.aouf.mallmanagement.bean.bo.AddCategoryBo;
import com.aouf.mallmanagement.bean.bo.SearchCategoryBo;
import com.aouf.mallmanagement.bean.po.Category;
import com.aouf.mallmanagement.service.IBrandService;
import com.aouf.mallmanagement.service.ICategoryService;
import com.aouf.mallmanagement.service.ISpuAttrKeyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private IBrandService brandService;
    private ISpuAttrKeyService spuAttrKeyService;
    @Autowired
    public void setSpuAttrKeyService(ISpuAttrKeyService spuAttrKeyService) {
        this.spuAttrKeyService = spuAttrKeyService;
    }

    @Autowired
    public void setBrandService(IBrandService brandService) {
        this.brandService = brandService;
    }

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
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("parents",categoryService.getAllParentCategories());
        model.addAttribute("brands",brandService.getAllBrand());
        model.addAttribute("keys",spuAttrKeyService.getFilterAll());
        return "/category/add";
    }
    @RequestMapping("/update")
    public String update(Model model,Integer cate_id){
        model.addAttribute("category",categoryService.getOne(cate_id));
        model.addAttribute("parents",categoryService.getAllParentCategories());
        model.addAttribute("brands",brandService.getAllBrand());
        model.addAttribute("keys",spuAttrKeyService.getFilterAll());
        return "/category/edit";
    }
    @RequestMapping("/save")
    @ResponseBody
    public String save(AddCategoryBo addCategoryBo){
        return categoryService.add(addCategoryBo);
    }
    @RequestMapping("/alter")
    @ResponseBody
    public String alter(AddCategoryBo addCategoryBo){
        return categoryService.update(addCategoryBo);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam(value = "ids[]") int[] ids){
        return categoryService.delete(ids);
    }
}
