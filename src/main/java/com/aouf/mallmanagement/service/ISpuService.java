package com.aouf.mallmanagement.service;

import com.aouf.mallmanagement.bean.bo.SearchSpuBo;
import com.aouf.mallmanagement.bean.po.Spu;
import com.github.pagehelper.PageInfo;

public interface ISpuService {
    PageInfo<Spu> getSpusByBo(SearchSpuBo searchSpuBo);
}
