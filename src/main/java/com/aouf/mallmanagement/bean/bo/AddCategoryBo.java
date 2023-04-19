package com.aouf.mallmanagement.bean.bo;

import com.aouf.mallmanagement.bean.po.Brand;
import com.aouf.mallmanagement.bean.po.SpuAttrKey;

import java.util.ArrayList;
import java.util.List;

public class AddCategoryBo {
    private Integer cate_id;
    private String cate_name;       //分类名称
    private Integer cate_sort;      //排序字段
    private Integer cate_parentid;  //父级分类id
    private List<Brand> brands = new ArrayList<>();
    private List<SpuAttrKey> keys = new ArrayList<>();

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public Integer getCate_sort() {
        return cate_sort;
    }

    public void setCate_sort(Integer cate_sort) {
        this.cate_sort = cate_sort;
    }

    public Integer getCate_parentid() {
        return cate_parentid;
    }

    public void setCate_parentid(Integer cate_parentid) {
        this.cate_parentid = cate_parentid;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public List<SpuAttrKey> getKeys() {
        return keys;
    }

    public void setKeys(List<SpuAttrKey> keys) {
        this.keys = keys;
    }
}
