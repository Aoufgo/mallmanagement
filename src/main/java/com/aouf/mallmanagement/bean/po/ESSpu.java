package com.aouf.mallmanagement.bean.po;

import java.util.Date;

//实体模型类-与es中的spu文档，要一一对应
public class ESSpu {
    private Long spu_id;                // 商品Spu编号
    private String spu_name;            // 商品Spu名称
    private String spu_title;           // 商品Spu标题
    private String spu_introduction;    // 商品Spu详情
    private String spu_unit;            // 商品Spu单位
    private Boolean spu_status;            // false下架(0)，true代表上架(1)
    private String spu_brand_id;        // 商品品牌编号
    private Date createtime;            // 创建时间
    private Date updatetime;            // 更新时间

    //访问器

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

    public String getSpu_introduction() {
        return spu_introduction;
    }

    public void setSpu_introduction(String spu_introduction) {
        this.spu_introduction = spu_introduction;
    }

    public String getSpu_unit() {
        return spu_unit;
    }

    public void setSpu_unit(String spu_unit) {
        this.spu_unit = spu_unit;
    }

    public Boolean getSpu_status() {
        return spu_status;
    }

    public void setSpu_status(Boolean spu_status) {
        this.spu_status = spu_status;
    }

    public String getSpu_brand_id() {
        return spu_brand_id;
    }

    public void setSpu_brand_id(String spu_brand_id) {
        this.spu_brand_id = spu_brand_id;
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
}
