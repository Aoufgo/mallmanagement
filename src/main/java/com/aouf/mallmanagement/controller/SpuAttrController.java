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
    ISpuAttrKeyService spuAttrKeyService;

    //todo 查询页面的视图方法
    @RequestMapping("/admin")
    public String admin(
            SearchSpuAttrKeyBo searchSpuAttrKeyBo,       //查询条件
            //页面中得到分页信息
            Model model                                  //需要辅助变量，要传递数据给thymeleaf页面
    ){
        //调用业务层的getList的方法
        PageInfo<SpuAttrKey> spuAttrKeyList = spuAttrKeyService.getList(searchSpuAttrKeyBo);

        //把数据传给html页面
        model.addAttribute("spuAttrKeyList",spuAttrKeyList);
        model.addAttribute("spuAttrKeySearchBo", searchSpuAttrKeyBo);

        return null;
    }
}
