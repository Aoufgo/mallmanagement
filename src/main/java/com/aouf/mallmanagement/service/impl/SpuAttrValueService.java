package com.aouf.mallmanagement.service.impl;

import com.aouf.mallmanagement.bean.po.SpuAttrValue;
import com.aouf.mallmanagement.mapper.SpuAttrValueMapper;
import com.aouf.mallmanagement.service.ISpuAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpuAttrValueService implements ISpuAttrValueService {
    private SpuAttrValueMapper spuAttrValueMapper;
    @Autowired
    public void setSpuAttrValueMapper(SpuAttrValueMapper spuAttrValueMapper) {
        this.spuAttrValueMapper = spuAttrValueMapper;
    }

    @Override
    public List<SpuAttrValue> getListByKeyId(String key_id) {
        return spuAttrValueMapper.getListByKeyId(key_id);
    }
}
