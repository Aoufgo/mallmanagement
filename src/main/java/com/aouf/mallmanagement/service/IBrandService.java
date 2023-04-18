package com.aouf.mallmanagement.service;

import com.aouf.mallmanagement.bean.bo.AddBrandBo;
import com.aouf.mallmanagement.bean.bo.SearchBrandBo;
import com.aouf.mallmanagement.bean.po.Brand;

import java.util.List;

//业务层接口类-负责品牌
public interface IBrandService {

    //通过brandid要查询一个品牌的实体信息
    Brand getOne(String brand_id);

    // 通过id或name查询,name为模糊查询
    List<Brand> getBrandsByBo(SearchBrandBo searchBrandBo);
    List<Brand> getAllBrand();
    Integer getBrandsByBoCount(SearchBrandBo searchBrandBo);

    //添加品牌信息
    int add(AddBrandBo addBrandBo);
}
