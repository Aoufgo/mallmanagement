package com.aouf.mallmanagement.bean.bo;



import com.aouf.mallmanagement.bean.po.Category;
import com.aouf.mallmanagement.bean.po.SpuAttrValueRelation;

import java.util.Date;
import java.util.List;

//实体类-负责修改商品信息
public class UpdateSpuBo {
    // spu_brand_id
    private Long spu_id;//spu编号
    private String spu_name;//spu名称
    private String spu_title;//标题

    private  String spu_introduction;//介绍
    private String spu_unit;//单位
    private Byte spu_status;//状态，0下架，1代表上架
    private Date createtime;//创建时间
    private Date updatetime;//修改时间
    private String spu_brand_id;//品牌编号

    public String getSpu_introduction() {
        return spu_introduction;
    }

    public void setSpu_introduction(String spu_introduction) {
        this.spu_introduction = spu_introduction;
    }

    private List<Category> categoryList;//分类列表
    private List<SpuAttrValueRelation> filterAttrValueList;//商品-筛选属性值关系列表
    private List<SpuAttrValueRelation> skuAttrValueList;//商品-规格属性值关系列表

    public Long getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Long spu_id) {
        this.spu_id = spu_id;
    }

    public String getSpu_name() {
        return spu_name;
    }

    public void setSpu_name(String spu_name) {
        this.spu_name = spu_name;
    }

    public String getSpu_title() {
        return spu_title;
    }

    public void setSpu_title(String spu_title) {
        this.spu_title = spu_title;
    }


    public String getSpu_unit() {
        return spu_unit;
    }

    public void setSpu_unit(String spu_unit) {
        this.spu_unit = spu_unit;
    }

    public Byte getSpu_status() {
        return spu_status;
    }

    public void setSpu_status(Byte spu_status) {
        this.spu_status = spu_status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getSpu_brand_id() {
        return spu_brand_id;
    }

    public void setSpu_brand_id(String spu_brand_id) {
        this.spu_brand_id = spu_brand_id;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<SpuAttrValueRelation> getFilterAttrValueList() {
        return filterAttrValueList;
    }

    public void setFilterAttrValueList(List<SpuAttrValueRelation> filterAttrValueList) {
        this.filterAttrValueList = filterAttrValueList;
    }

    public List<SpuAttrValueRelation> getSkuAttrValueList() {
        return skuAttrValueList;
    }

    public void setSkuAttrValueList(List<SpuAttrValueRelation> skuAttrValueList) {
        this.skuAttrValueList = skuAttrValueList;
    }
}
