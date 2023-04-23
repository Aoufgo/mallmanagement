package com.aouf.mallmanagement.controller;

import com.aouf.mallmanagement.bean.bo.SearchSpuBo;
import com.aouf.mallmanagement.bean.bo.UpdateSpuBo;
import com.aouf.mallmanagement.bean.po.Brand;
import com.aouf.mallmanagement.bean.po.Category;
import com.aouf.mallmanagement.bean.po.Spu;
import com.aouf.mallmanagement.bean.po.SpuAttrKey;
import com.aouf.mallmanagement.bean.vo.SpuVo;
import com.aouf.mallmanagement.service.ICategoryService;
import com.aouf.mallmanagement.service.ISpuAttrKeyService;
import com.aouf.mallmanagement.service.impl.BrandService;
import com.aouf.mallmanagement.service.impl.SpuService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private ICategoryService categoryService;

    @Resource
    private ISpuAttrKeyService spuAttrKeyService;

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


    //修改商品-视图方法
    @RequestMapping("/update")
    public String update(
            Long spu_id,
            Model model
    ){
        //页面中需要spuvo的类型
        SpuVo spuVo = spuService.getVoBySpuId(spu_id);
        model.addAttribute("spu",spuVo);
        //需要所有品牌列表的数据
        List<Brand> brandList = brandService.getAllBrand();
        model.addAttribute("brandList",brandList);
        //需要所有分类的数据
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList",categoryList);
        //需要所有筛选属性键的数据
        List<SpuAttrKey> filterList =spuAttrKeyService.getFilterAll();
        model.addAttribute("filterList",filterList);
        //需要所有规格属性键的数据
        List<SpuAttrKey> skuList = spuAttrKeyService.getSkuAll();
        model.addAttribute("skuList",skuList);
        return "/spu/edit";
    }
    @RequestMapping("/add")
    public String add(Model model){
        //需要所有品牌列表的数据
        List<Brand> brandList = brandService.getAllBrand();
        model.addAttribute("brandList",brandList);
        //需要所有分类的数据
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList",categoryList);
        //需要所有筛选属性键的数据
        List<SpuAttrKey> filterList =spuAttrKeyService.getFilterAll();
        model.addAttribute("filterList",filterList);
        //需要所有规格属性键的数据
        List<SpuAttrKey> skuList = spuAttrKeyService.getSkuAll();
        model.addAttribute("skuList",skuList);
        return "/spu/add";
    }
    //执行修改商品
    @RequestMapping("/alter")
    @ResponseBody
    public String alter(UpdateSpuBo updateSpuBo){
        return spuService.update(updateSpuBo);
    }
    @RequestMapping("/save")
    @ResponseBody
    public String save(UpdateSpuBo updateSpuBo){
        return spuService.save(updateSpuBo);
    }

}
