package com.aouf.mallmanagement.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.aouf.mallmanagement.bean.bo.SearchSpuBo;
import com.aouf.mallmanagement.bean.bo.UpdateSpuBo;
import com.aouf.mallmanagement.bean.po.Category;
import com.aouf.mallmanagement.bean.po.Spu;
import com.aouf.mallmanagement.bean.po.SpuAttrValueRelation;
import com.aouf.mallmanagement.bean.vo.SpuVo;
import com.aouf.mallmanagement.mapper.SpuMapper;
import com.aouf.mallmanagement.service.ISpuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @Override
    public SpuVo getVoBySpuId(Long spu_id) {
        return spuMapper.getVo(spu_id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String update(UpdateSpuBo updateSpuBo) {
        // 手动回滚
        try {
            // 設置更新時間
            updateSpuBo.setUpdatetime(new Date());
            // 更新spu
            spuMapper.update(updateSpuBo);
            // 刪除添加商品-分類數據
            spuMapper.deleteCateSpuBySpuId(updateSpuBo.getSpu_id());
            for (Category category : updateSpuBo.getCategoryList()) {
                spuMapper.addCateSpu(category.getCate_id(), updateSpuBo.getSpu_id());
            }
            // 刪除商品-屬性數據
            spuMapper.deleteAttrValueSpuBySpuId(updateSpuBo.getSpu_id());
            // 添加商品-筛选属性
            for (SpuAttrValueRelation spuAttrValueRelation : updateSpuBo.getFilterAttrValueList()) {
                spuMapper.addAttrValueSpu(spuAttrValueRelation);
            }
            //遍歷當前規格圖片信息
            for (SpuAttrValueRelation spuAttrValueRelation : updateSpuBo.getSkuAttrValueList()) {
                if (!spuAttrValueRelation.getSpu_attr_image_list()[0].isEmpty()) {
                    //相册字符串数组;初始化需要初始化多个元素？..引用length属性即可
                    String[] albums = new String[spuAttrValueRelation.getSpu_attr_image_list().length];
                    int index = 0;
                    for (MultipartFile img :
                            spuAttrValueRelation.getSpu_attr_image_list()) {//内层循环，得到当前规格属性值，上传的图片列表
                        System.out.println("提交的相册：" + img.getOriginalFilename());

                        //执行上传图片.. 生成一个随机的图片名称...需要修改当前的规格属性值.spu_attr_imgs[外层循环中的成员属性]
                        //调用UUID类，生成随机的文件名
                        String filename = UUID.randomUUID().toString();

                        //拼接出新的文件名（随机主名+.+原来的扩展名）
                        filename += img.getOriginalFilename().substring(
                                img.getOriginalFilename().lastIndexOf("."));
                        // 实例化 File对象 映射 要保存的路径
                        File target = new File(
                                ResourceUtils.getURL("classpath:").getPath() +
                                        "static/img/" + filename
                        );
                        // 将临时文件 从 临时目录 迁移到 指定的目录
                        //在multipart的对象上，执行transfer的方法（让java服务端把图片流保存下来）
                        img.transferTo(target);
                        //把保存好服务器文件名，存到一个String[]，需要引用相册的索引值
                        albums[index] = filename;
                        index++;
                    }
                    spuAttrValueRelation.setSpu_attr_imgs(JSON.toJSONString(albums));
                }
            }
            // 添加商品-sku属性
            for (SpuAttrValueRelation spuAttrValueRelation : updateSpuBo.getSkuAttrValueList()) {
                spuMapper.addAttrValueSpu(spuAttrValueRelation);
            }
                return "更新成功";
        }catch (Exception e){
            // 可以在出现异常回滚时设置返回值
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return "更新失败";
        }

    }
}
