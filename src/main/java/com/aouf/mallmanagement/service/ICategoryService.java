package com.aouf.mallmanagement.service;

import com.aouf.mallmanagement.bean.bo.AddCategoryBo;
import com.aouf.mallmanagement.bean.bo.SearchCategoryBo;
import com.aouf.mallmanagement.bean.po.Category;
import com.github.pagehelper.PageInfo;

import java.util.List;

//业务层接口类-负责分类业务
public interface ICategoryService {
    //通过分类id，查找1个分类实体
    Category getOne(int cate_id);
    PageInfo<Category> getCategoriesByBo(SearchCategoryBo searchCategoryBo);
    List<Category> getAllParentCategories();
    String add(AddCategoryBo addCategoryBo);

    String update(AddCategoryBo addCategoryBo);
    String delete(int[] ids);

    List<Category> getAll();
}
