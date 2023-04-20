package com.aouf.mallmanagement.service;

import com.aouf.mallmanagement.bean.bo.SearchSpuBo;
import com.aouf.mallmanagement.bean.bo.UpdateSpuBo;
import com.aouf.mallmanagement.bean.po.Spu;

import com.aouf.mallmanagement.bean.vo.SpuVo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//业务层接口类-负责商品业务
public interface ISpuService {

    PageInfo<Spu> getSpusByBo(SearchSpuBo searchSpuBo);

    //通过商品编号，查询到spuvo的实例
    SpuVo getVoBySpuId(Long spu_id);

    String update(UpdateSpuBo updateSpuBo);
}
