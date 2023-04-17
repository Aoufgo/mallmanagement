package com.aouf.mallmanagement.bean.po;

import java.sql.Timestamp;
import java.util.List;

//实体模型类-和数据库中的category表一一对应
public class Category {
    //成员属性
    private Integer cate_id;        //分类id
    private String cate_name;       //分类名称
    private Integer cate_sort;      //排序字段
    private Timestamp createtime;   //创建时间（数据库中是timestamp类型）
    private Timestamp updatetime;   //修改时间
    private Integer cate_parentid;  //父级分类id
    private String cate_parentname;
    private List<Brand> brands;
    private List<SpuAttrKey> spuAttrKeys;

    public String getCate_parentname() {
        return cate_parentname;
    }

    public void setCate_parentname(String cate_parentname) {
        this.cate_parentname = cate_parentname;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public List<SpuAttrKey> getSpuAttrKeys() {
        return spuAttrKeys;
    }

    public void setSpuAttrKeys(List<SpuAttrKey> spuAttrKeys) {
        this.spuAttrKeys = spuAttrKeys;
    }
//访问器

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

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getCate_parentid() {
        return cate_parentid;
    }

    public void setCate_parentid(Integer cate_parentid) {
        this.cate_parentid = cate_parentid;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "Category{" +
                "cate_id=" + cate_id +
                ", cate_name='" + cate_name + '\'' +
                ", cate_sort=" + cate_sort +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", cate_parentid=" + cate_parentid +
                '}';
    }
}
