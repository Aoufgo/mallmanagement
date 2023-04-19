package com.aouf.mallmanagement.mapper;

import com.aouf.mallmanagement.bean.bo.SearchSpuBo;
import com.aouf.mallmanagement.bean.po.Spu;
import com.aouf.mallmanagement.bean.vo.SpuVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpuMapper {
    Page<Spu> getSpusByBo(SearchSpuBo searchSpuBo);
    // 查询 满足条件的 含有品牌信息 的 商品Spu列表

    //根据商品编号，得到1个商品的vo对象
    SpuVo getVo(
            @Param("spu_id")
            Long spu_id);
}
