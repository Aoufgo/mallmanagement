package com.aouf.mallmanagement.service.impl;

import com.aouf.mallmanagement.bean.bo.AddSpuAttrKeyBo;
import com.aouf.mallmanagement.bean.bo.SearchSpuAttrKeyBo;
import com.aouf.mallmanagement.bean.po.SpuAttrKey;
import com.aouf.mallmanagement.bean.po.SpuAttrValue;
import com.aouf.mallmanagement.mapper.SpuAttrKeyMapper;
import com.aouf.mallmanagement.mapper.SpuAttrValueMapper;
import com.aouf.mallmanagement.service.ISpuAttrKeyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SpuAttrKeyService implements ISpuAttrKeyService {
    private SpuAttrKeyMapper spuAttrKeyMapper;
    private SpuAttrValueMapper spuAttrValueMapper;
    @Autowired
    public void setSpuAttrValueMapper(SpuAttrValueMapper spuAttrValueMapper) {
        this.spuAttrValueMapper = spuAttrValueMapper;
    }

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
    //使用Pagehelper来实现的分页
    @Override
    public PageInfo<SpuAttrKey> getList(SearchSpuAttrKeyBo searchSpuAttrKeyBo){
        PageHelper.startPage(searchSpuAttrKeyBo.getPage(),searchSpuAttrKeyBo.getPageSize());
        return new PageInfo<>(spuAttrKeyMapper.getList(searchSpuAttrKeyBo));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String add(AddSpuAttrKeyBo addSpuAttrKeyBo) {
        // 手动回滚
        try {
            // 设置key_id
            String key_id = UUID.randomUUID().toString();
            addSpuAttrKeyBo.setKey_id(key_id);
            // 设置添加时间
            addSpuAttrKeyBo.setCreatetime(new Timestamp(System.currentTimeMillis()));
            // 添加spu_attr_key
            spuAttrKeyMapper.addSpuAttrKey(addSpuAttrKeyBo);
            // 遍历value
            for (SpuAttrValue spuAttrValue : addSpuAttrKeyBo.getSpuAttrValueList()) {
                // 设置添加时间
                spuAttrValue.setCreatetime(new Date());
                // 设置key_id
                spuAttrValue.setValue_attr_key_id(key_id);
                // 添加value
                spuAttrValueMapper.addSpuAttrValue(spuAttrValue);
            }
            return "添加成功";
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return "添加失败";
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String update(AddSpuAttrKeyBo addSpuAttrKeyBo) {
        // 手动回滚
        try {
            // 设置添加时间
            addSpuAttrKeyBo.setUpdatetime(new Timestamp(System.currentTimeMillis()));
            // 更新spu_attr_key
            spuAttrKeyMapper.updateSpuAttrKey(addSpuAttrKeyBo);
            // 遍历value
            for (SpuAttrValue spuAttrValue : addSpuAttrKeyBo.getSpuAttrValueList()) {
                // 设置添加时间
                spuAttrValue.setCreatetime(new Date());
                // 设置key_id
                spuAttrValue.setValue_attr_key_id(addSpuAttrKeyBo.getKey_id());
                // 添加value
                spuAttrValueMapper.addSpuAttrValue(spuAttrValue);
            }
            return "更新成功";
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return "更新失败";
        }
    }

    @Override
    public SpuAttrKey getOne(String key_id) {
        return spuAttrKeyMapper.getOne(key_id);
    }
}
