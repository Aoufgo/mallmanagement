package com.aouf.mallmanagement.service.impl;

import com.aouf.mallmanagement.bean.bo.SearchCategoryBo;
import com.aouf.mallmanagement.bean.po.Category;
import com.aouf.mallmanagement.mapper.CategoryMapper;
import com.aouf.mallmanagement.service.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//业务层实现类-负责分类业务
@Service            //代表将当前类型托管给spring框架/将当前类型转换成springbean
public class CategoryService implements ICategoryService {

    //成员属性,下层对象是数据访问层CategoryMapper接口类型(Autowired/Resource注解二选一)
    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public Category getOne(int cate_id) {
        return categoryMapper.getOne(cate_id);
    }

    @Override
    public PageInfo<Category> getCategoriesByBo(SearchCategoryBo searchCategoryBo) {
        PageHelper.startPage(searchCategoryBo.getPage(),searchCategoryBo.getPageSize());
        return new PageInfo<>(categoryMapper.getCategoriesByBo(searchCategoryBo));
    }

    @Override
    public List<Category> getAllParentCategories() {
        return categoryMapper.getAllParentCategories();
    }
}
