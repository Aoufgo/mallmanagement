package com.aouf.mallmanagement.controller;

import com.alibaba.fastjson.JSON;
import com.aouf.mallmanagement.service.impl.SpuAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/attr-value")
public class SpuAttrValueController {
    private SpuAttrValueService spuAttrValueService;
    @Autowired
    public void setSpuAttrValueService(SpuAttrValueService spuAttrValueService) {
        this.spuAttrValueService = spuAttrValueService;
    }

    @RequestMapping("/getListByKeyId")
    @ResponseBody
    public String getListByKeyId(String key_id){
        return JSON.toJSONString(spuAttrValueService.getListByKeyId(key_id));
    }
}
