package com.aouf.mallmanagement.service;

import com.aouf.mallmanagement.bean.bo.AddSpuAttrKeyBo;
import com.aouf.mallmanagement.bean.bo.SearchSpuAttrKeyBo;
import com.aouf.mallmanagement.bean.po.SpuAttrKey;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ISpuAttrKeyService {
    //得到所有筛选属性键的列表数据
    List<SpuAttrKey> getFilterAll();

    //得到所有规格属性键的列表数据
    List<SpuAttrKey> getSkuAll();

    //按照查询条件，得到属性键的列表数据
    PageInfo<SpuAttrKey> getList(SearchSpuAttrKeyBo searchSpuAttrKeyBo);

    String add(AddSpuAttrKeyBo addSpuAttrKeyBo);
    String update(AddSpuAttrKeyBo addSpuAttrKeyBo);

    SpuAttrKey getOne(String key_id);
}
