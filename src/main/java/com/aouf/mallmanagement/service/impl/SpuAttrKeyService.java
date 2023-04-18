package com.aouf.mallmanagement.service.impl;

import com.aouf.mallmanagement.bean.po.SpuAttrKey;
import com.aouf.mallmanagement.mapper.SpuAttrKeyMapper;
import com.aouf.mallmanagement.service.ISpuAttrKeyService;
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
    public List<SpuAttrKey> getAllKey() {
        return spuAttrKeyMapper.getAllKey();
    }
}
