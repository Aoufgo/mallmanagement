package com.aouf.mallmanagement.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;

import com.aouf.mallmanagement.bean.bo.AddBrandBo;
import com.aouf.mallmanagement.bean.bo.SearchBrandBo;
import com.aouf.mallmanagement.bean.po.Brand;
import com.aouf.mallmanagement.service.IBrandService;
import com.aouf.mallmanagement.service.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//视图类-负责品牌的访问
@Controller
@RequestMapping("/brand")
public class BrandController {
    private IBrandService brandService;
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    //查询品牌列表的视图方法
    @RequestMapping("/admin")        //访问到/brand/list的时候，定位到当前视图文件
    public String list(Model model, SearchBrandBo searchBrandBo){
        List<Brand> brandsByBo = brandService.getBrandsByBo(searchBrandBo);
        model.addAttribute("list",brandsByBo);
        System.out.println(brandsByBo.size());
        System.out.println(searchBrandBo.getPageSize());
        model.addAttribute("pageCount",(int)Math.ceil((float)brandService.getBrandsByBoCount(searchBrandBo)/ searchBrandBo.getPageSize()));
        model.addAttribute("page",searchBrandBo.getPage());
        model.addAttribute("pageSize",searchBrandBo.getPageSize());
        return "/brand/list";
    }

    //添加品牌的视图方法
    @RequestMapping("/add")
    public String add(){
        return null;                //采用/brand/add.html视图响应
    }

    //添加品牌的视图方法
    @RequestMapping("/save")
    public String save(AddBrandBo addBrandBo){
        System.out.println(addBrandBo.getBrand_image().getOriginalFilename());
        brandService.add(addBrandBo);
        return "brand/list";
    }
}
