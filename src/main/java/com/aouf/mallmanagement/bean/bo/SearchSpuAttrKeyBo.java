package com.aouf.mallmanagement.bean.bo;

//属性键的查询条件bo类
public class SearchSpuAttrKeyBo {
    //成员属性
    private String key_id;  //属性键id
    private String key_name;    //属性键名称
    private Byte    key_issku;  //是否规格属性，0代表筛选、1代表规格
    private Byte    key_ishigh; //是否高级属性，0代表普通，1代表高级

    //访问器


    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public Byte getKey_issku() {
        return key_issku;
    }

    public void setKey_issku(Byte key_issku) {
        this.key_issku = key_issku;
    }

    public Byte getKey_ishigh() {
        return key_ishigh;
    }

    public void setKey_ishigh(Byte key_ishigh) {
        this.key_ishigh = key_ishigh;
    }
}
