package com.aouf.mallmanagement.bean.bo;

import com.aouf.mallmanagement.bean.po.SpuAttrValue;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AddSpuAttrKeyBo {
    private String key_id;
    private String key_name;
    private Integer key_issku;
    private Integer key_ishigh;
    private Timestamp createtime;   //创建时间（数据库中是timestamp类型）
    private Timestamp updatetime;   //修改时间
    private List<SpuAttrValue> spuAttrValueList = new ArrayList<>();

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

    public Integer getKey_issku() {
        return key_issku;
    }

    public void setKey_issku(Integer key_issku) {
        this.key_issku = key_issku;
    }

    public Integer getKey_ishigh() {
        return key_ishigh;
    }

    public void setKey_ishigh(Integer key_ishigh) {
        this.key_ishigh = key_ishigh;
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

    public List<SpuAttrValue> getSpuAttrValueList() {
        return spuAttrValueList;
    }

    public void setSpuAttrValueList(List<SpuAttrValue> spuAttrValueList) {
        this.spuAttrValueList = spuAttrValueList;
    }
}
