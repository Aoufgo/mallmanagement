package com.aouf.mallmanagement.bean.po;

import java.util.Date;

//实体类-负责品牌表brand
public class Brand {
    //成员属性
    private String brand_id;    //品牌编号
    private String brand_name;  //品牌名称
    private String brand_introduction;  //介绍
    private String brand_logourl;   //logo....需要存放一个品牌图片的信息（添加brand的时候需要用图片上传的功能来做）
                                    //此处存放的是图片的url路径
    private Integer sortno;         //展现时的排序字段
    private Date createtime;        //创建时间
    private Date updatetime;        //修改时间


    //设置get和set访问器

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_introduction() {
        return brand_introduction;
    }

    public void setBrand_introduction(String brand_introduction) {
        this.brand_introduction = brand_introduction;
    }

    public String getBrand_logourl() {
        return brand_logourl;
    }

    public void setBrand_logourl(String brand_logourl) {
        this.brand_logourl = brand_logourl;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
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


    //重写toString方法

    @Override
    public String toString() {
        return "Brand{" +
                "brand_id='" + brand_id + '\'' +
                ", brand_name='" + brand_name + '\'' +
                ", brand_introduction='" + brand_introduction + '\'' +
                ", brand_logourl='" + brand_logourl + '\'' +
                ", sortno=" + sortno +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                '}';
    }
}
