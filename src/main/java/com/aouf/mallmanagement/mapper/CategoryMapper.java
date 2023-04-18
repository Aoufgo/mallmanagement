package com.aouf.mallmanagement.mapper;


import com.aouf.mallmanagement.bean.bo.AddCategoryBo;
import com.aouf.mallmanagement.bean.bo.SearchCategoryBo;
import com.aouf.mallmanagement.bean.po.Category;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//数据访问层接口类-负责分类业务
@Repository         //代表托管给spring框架
public interface CategoryMapper {
    //抽象方法
    //通过分类的id，查询1个分类实体信息
    Category getOne(
            @Param("cate_id")       //需要将当前修饰的入参cate_id的值，传递给xml文件中sql语句中对应的cate_id的变量
            int cate_id
    );
    Page<Category> getCategoriesByBo(SearchCategoryBo searchCategoryBo);
    List<Category> getAllParentCategories();
    Integer add(AddCategoryBo addCategoryBo);
    Integer addBrandCate(String brand_id,Integer category_id);
    Integer deleteBrandCateByCateId(Integer category_id);
    Integer addKeyCate(String spu_attr_key_id,Integer category_id);
    Integer deleteKeyCateByCateId(Integer category_id);

}
