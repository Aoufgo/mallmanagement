package com.aouf.mallmanagement.mapper;

import com.aouf.mallmanagement.bean.bo.AddBrandBo;
import com.aouf.mallmanagement.bean.bo.SearchBrandBo;
import com.aouf.mallmanagement.bean.po.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//数据访问层接口类，负责品牌业务
@Repository                 //需要托管给spring框架，被调用时由spring框架的context来实例化
public interface BrandMapper {

    //根据一个品牌id要查询品牌的实体信息
    Brand getOne(
            @Param("brand_id")      //当前的入参，需要和brandmapper.xml中的sql要数据交互
            String brand_id);

    List<Brand> getBrandsByBo(SearchBrandBo searchBrandBo);
    List<Brand> getAllBrand();
    Integer getBrandsByBoCount(SearchBrandBo searchBrandBo);

    //添加品牌........适配于添加品牌的界面
    int add(
            @Param("addBrandBo")
            AddBrandBo addBrandBo
    );


    //按照某种查询条件要查询品牌列表...适配于品牌查询的界面

    //todo，
    //修改品牌信息
    //根据品牌id，删除1条品牌信息
    //批量删除品牌信息
}
