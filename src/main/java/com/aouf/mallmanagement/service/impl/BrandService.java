package com.aouf.mallmanagement.service.impl;

import com.aouf.mallmanagement.bean.bo.AddBrandBo;
import com.aouf.mallmanagement.bean.bo.SearchBrandBo;
import com.aouf.mallmanagement.bean.po.Brand;
import com.aouf.mallmanagement.mapper.BrandMapper;
import com.aouf.mallmanagement.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.UUID;

//业务层实现类-负责品牌业务
@Service                //需要托管给spring框架，被其他人使用调用时需要由spring的context对象来自动实例化
public class BrandService
                implements IBrandService {

    //成员属性（需要调用下层--BrandMapper）
    @Autowired          //需要由spring框架来自动实例化
            BrandMapper brandMapper;


    //成员方法
    @Override
    public Brand getOne(String brand_id) {
        return brandMapper.getOne(brand_id);
    }

    @Override
    public List<Brand> getBrandsByBo(SearchBrandBo searchBrandBo) {
        return brandMapper.getBrandsByBo(searchBrandBo);
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandMapper.getAllBrand();
    }

    @Override
    public Integer getBrandsByBoCount(SearchBrandBo searchBrandBo) {
        return brandMapper.getBrandsByBoCount(searchBrandBo);
    }

    //添加品牌
    //界面上需要录入品牌名、品牌介绍、排序字段
    @Override
    public int add(AddBrandBo addBrandBo) {
        int status = -1 ;           //-1代表失败；大于0代表添加成功
        addBrandBo.setBrand_id(UUID.randomUUID().toString());       //使用UUID类来生成，brand_id，36字节的随机字符串

        //判断brand_image成员属性的image类型
        if( !addBrandBo.getBrand_image().getContentType().startsWith("image") ){
            return status;
        }

        //判断brand_image成员属性的文件大小（10M以内）是否超标
        if(addBrandBo.getBrand_image().getSize()>= 10 * 1024 * 1024 ){
            return status;
        }

        //调用UUID类，生成随机的文件名
        String filename = UUID.randomUUID().toString();
        // 拼接文件的扩展名
        filename += addBrandBo.getBrand_image().getOriginalFilename().substring(
                addBrandBo.getBrand_image().getOriginalFilename().lastIndexOf(".") );
        System.out.println("随机生成的文件路径："+filename);

        //把图片流存到java服务器指定的目录
        try {
            // 实例化 File对象 映射 要保存的路径
            File target = new File(
                    ResourceUtils.getURL("classpath:").getPath() +
                            "static/img/" + filename
            );
            // 将临时文件 从 临时目录 迁移到 指定的目录
            addBrandBo.getBrand_image().transferTo( target );
        } catch (Exception e) {
            e.printStackTrace();
        }

        //把随机生成的文件名要更新到成员属性，brand_logourl
        addBrandBo.setBrand_logourl(filename);

        return brandMapper.add(addBrandBo);
    }

}
