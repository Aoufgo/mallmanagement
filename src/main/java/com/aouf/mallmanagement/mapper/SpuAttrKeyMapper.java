package com.aouf.mallmanagement.mapper;

import com.aouf.mallmanagement.bean.bo.AddCategoryBo;
import com.aouf.mallmanagement.bean.bo.AddSpuAttrKeyBo;
import com.aouf.mallmanagement.bean.bo.SearchSpuAttrKeyBo;
import com.aouf.mallmanagement.bean.po.SpuAttrKey;
import com.aouf.mallmanagement.bean.vo.AttributeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpuAttrKeyMapper {
    List<SpuAttrKey> getAllKey();
    List<SpuAttrKey> getFilterAll();

    //得到所有规格属性键列表
    List<SpuAttrKey> getSkuAll();

    //批量添加筛选属性键-分类数据
    int multiAddCateAttr(
            @Param("addCategoryBo")
            AddCategoryBo addCategoryBo);

    //通过cate_id，得到筛选属性键的数据
    List<SpuAttrKey> getListByCate(
            @Param("cate_id")
            Integer cate_id
    );


    //删除-分类-筛选属性键关联表的数据
    int delCateAttrKey(@Param("cate_id") Integer cate_id);

    //批量删除-分类-筛选属性键关联表的数据
    int multiDelAttrKey(@Param("id_list") Integer[] id_list);

    //按照查询条件，找属性键列表的数据
    List<SpuAttrKey> getList(
            @Param("searchSpuAttrKeyBo") SearchSpuAttrKeyBo searchSpuAttrKeyBo);

    //根据商品id，查询这个商品的关联，筛选属性信息
    List<AttributeVo> getFiltersBySpuId(
            @Param("spu_id")Long spu_id
    );

    //根据商品id，查询这个商品的关联，规格属性信息
    List<AttributeVo> getSkusBySpuId(
            @Param("spu_id")Long spu_id
    );

    Integer addSpuAttrKey(AddSpuAttrKeyBo addSpuAttrKeyBo);

    Integer updateSpuAttrKey(AddSpuAttrKeyBo addSpuAttrKeyBo);

    SpuAttrKey getOne(String key_id);

}
