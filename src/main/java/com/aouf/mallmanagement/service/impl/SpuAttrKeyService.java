package com.aouf.mallmanagement.service.impl;

import com.aouf.mallmanagement.bean.bo.SpuAttrKeySearchBo;
import com.aouf.mallmanagement.bean.po.SpuAttrKey;
import com.aouf.mallmanagement.mapper.SpuAttrKeyMapper;
import com.aouf.mallmanagement.service.ISpuAttrKeyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuAttrKeyService implements ISpuAttrKeyService {
    private SpuAttrKeyMapper spuAttrKeyMapper;

    @Autowired
    public void setSpuAttrKeyMapper(SpuAttrKeyMapper spuAttrKeyMapper) {
        this.spuAttrKeyMapper = spuAttrKeyMapper;
    }



    @Override
    public List<SpuAttrKey> getFilterAll() {
        return spuAttrKeyMapper.getFilterAll();
    }

    @Override
    public List<SpuAttrKey> getSkuAll() {
        return spuAttrKeyMapper.getSkuAll();
    }
    //todo 使用Pagehelper来实现的分页
    @Override
    public PageInfo<SpuAttrKey> getList(SpuAttrKeySearchBo spuAttrKeySearchBo){
        return null;
    }
}
