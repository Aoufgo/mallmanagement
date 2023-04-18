package com.aouf.mallmanagement.service.impl;

import com.aouf.mallmanagement.bean.bo.SearchSpuBo;
import com.aouf.mallmanagement.bean.po.Spu;
import com.aouf.mallmanagement.mapper.SpuMapper;
import com.aouf.mallmanagement.service.ISpuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpuService implements ISpuService {
    private SpuMapper spuMapper;
    @Autowired
    public void setSpuMapper(SpuMapper spuMapper) {
        this.spuMapper = spuMapper;
    }

    @Override
    public PageInfo<Spu> getSpusByBo(SearchSpuBo searchSpuBo) {
        PageHelper.startPage(searchSpuBo.getPage(),searchSpuBo.getPageSize());
        return new PageInfo<>(spuMapper.getSpusByBo(searchSpuBo));
    }
}
