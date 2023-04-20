package com.aouf.mallmanagement.controller;


import com.aouf.mallmanagement.bean.bo.SearchSpuAttrKeyBo;
import com.aouf.mallmanagement.bean.po.SpuAttrKey;
import com.aouf.mallmanagement.service.ISpuAttrKeyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//视图类-负责属性键的业务
@Controller
@RequestMapping("/attr")
public class SpuAttrController {

    //成员属性
    @Autowired
    private ISpuAttrKeyService spuAttrKeyService;

    //查询页面的视图方法
    @RequestMapping("/admin")
    public String admin(
            SearchSpuAttrKeyBo searchSpuAttrKeyBo, Model model){
        //调用业务层的getList的方法
        PageInfo<SpuAttrKey> spuAttrKeyPageInfo = spuAttrKeyService.getList(searchSpuAttrKeyBo);
        //把数据传给html页面
        model.addAttribute("spuAttrKeyList",spuAttrKeyPageInfo.getList());
        model.addAttribute("spuAttrKeySearchBo", searchSpuAttrKeyBo);
        model.addAttribute("pageCount", spuAttrKeyPageInfo.getPages());
        model.addAttribute("page",searchSpuAttrKeyBo.getPage());
        model.addAttribute("pageSize",searchSpuAttrKeyBo.getPageSize());
        return "/attr/list";
    }
    @RequestMapping("/add")
    public String add(){
        //todo 属性添加
        return null;
    }
    @RequestMapping("/update")
    public String update(){
        //todo 属性更新
        return null;
    }
}
