package com.aouf.mallmanagement.bean.po;

import org.springframework.web.multipart.MultipartFile;

//产品-属性值表（对应mysql表spu_attr_value_spus）
public class SpuAttrValueRelation {
    private Integer id;
    private  Long spu_attr_value_id;//属性值id
    private String spu_attr_imgs="[]";//属性值相册，默认值代表空的json字符串
    private Long spu_id;//商品id

    private MultipartFile[] spu_attr_image_list;//商品相册上传的文件
                                                //MultipartFile类型，springmvc中提供的上传java类型，批量

    public MultipartFile[] getSpu_attr_image_list() {
        return spu_attr_image_list;
    }

    public void setSpu_attr_image_list(MultipartFile[] spu_attr_image_list) {
        this.spu_attr_image_list = spu_attr_image_list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSpu_attr_value_id() {
        return spu_attr_value_id;
    }

    public void setSpu_attr_value_id(Long spu_attr_value_id) {
        this.spu_attr_value_id = spu_attr_value_id;
    }

    public String getSpu_attr_imgs() {
        return spu_attr_imgs;
    }

    public void setSpu_attr_imgs(String spu_attr_imgs) {
        this.spu_attr_imgs = spu_attr_imgs;
    }

    public Long getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Long spu_id) {
        this.spu_id = spu_id;
    }
}