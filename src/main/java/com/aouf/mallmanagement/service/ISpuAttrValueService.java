package com.aouf.mallmanagement.service;

import com.aouf.mallmanagement.bean.po.SpuAttrValue;

import java.util.List;

public interface ISpuAttrValueService {
    List<SpuAttrValue> getListByKeyId(String key_id);
}
