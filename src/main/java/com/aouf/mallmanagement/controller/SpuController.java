package com.aouf.mallmanagement.controller;

import com.aouf.mallmanagement.bean.bo.SearchSpuBo;
import com.aouf.mallmanagement.bean.po.Spu;
import com.aouf.mallmanagement.service.impl.BrandService;
import com.aouf.mallmanagement.service.impl.SpuService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spu")
public class SpuController {
    private SpuService spuService;
    @Autowired
    public void setSpuService(SpuService spuService) {
        this.spuService = spuService;
    }

    private BrandService brandService;
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @RequestMapping("/admin")
    public String admin(Model model, SearchSpuBo searchSpuBo){
        PageInfo<Spu> spuPageInfo = spuService.getSpusByBo(searchSpuBo);
        model.addAttribute("brands",brandService.getAllBrand());
        model.addAttribute("spus",spuPageInfo.getList());

        model.addAttribute("searchSpuBo",searchSpuBo);
        model.addAttribute("pageCount", spuPageInfo.getPages());
        model.addAttribute("page",searchSpuBo.getPage());
        model.addAttribute("pageSize",searchSpuBo.getPageSize());

        return "spu/list";
    }

}
