package com.aouf.mallmanagement.service;

import com.aouf.mallmanagement.bean.po.Category;

//业务层接口类-负责分类业务
public interface ICategoryService {
    //通过分类id，查找1个分类实体
    Category getOne(int cate_id);
}
