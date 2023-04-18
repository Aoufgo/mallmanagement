package com.aouf.mallmanagement.mapper;

import com.aouf.mallmanagement.bean.bo.SearchSpuBo;
import com.aouf.mallmanagement.bean.po.Spu;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpuMapper {
    Page<Spu> getSpusByBo(SearchSpuBo searchSpuBo);
}
