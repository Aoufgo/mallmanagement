package com.aouf.mallmanagement.mapper;

import com.aouf.mallmanagement.bean.po.SpuAttrValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpuAttrValueMapper {
    List<SpuAttrValue> getListByKeyId(String key_id);

    Integer addSpuAttrValue(SpuAttrValue spuAttrValue);
}
