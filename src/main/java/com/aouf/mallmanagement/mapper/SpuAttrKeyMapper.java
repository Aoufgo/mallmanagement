package com.aouf.mallmanagement.mapper;

import com.aouf.mallmanagement.bean.po.SpuAttrKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpuAttrKeyMapper {
    List<SpuAttrKey> getAllKey();

}
