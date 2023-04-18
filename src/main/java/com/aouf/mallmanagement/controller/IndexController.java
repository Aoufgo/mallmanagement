package com.aouf.mallmanagement.controller;

import com.aouf.mallmanagement.bean.po.Admin;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( value = { "/index" } )
public class IndexController {

    @RequestMapping( value = {  "/index" } )
    public String index(
            Authentication auth,
            Model model
    ){
        // 获取当前登录的员工对象
        Admin admin = (Admin)auth.getPrincipal();

        // 将 数据添加到 Model模型数据中
        model.addAttribute( "admin" , admin );
        return "index/index";
    }

    @RequestMapping("/home")
    public String home(){
        return "index/home";
    }

    @RequestMapping("/login")
    public String login(){
        return "index/login";
    }

    @RequestMapping("/success")
    public String success(
            String message,
            String detail,
            String controller,
            Model model
    ){
        model.addAttribute("message",message);
        model.addAttribute("detail",detail);
        model.addAttribute("controller",controller);
        return "index/success";
    }

    @RequestMapping("/error")
    public String error(
            String message,
            String detail,
            String controller,
            Model model
    ){
        model.addAttribute("message",message);
        model.addAttribute("detail",detail);
        model.addAttribute("controller",controller);
        return "index/error";
    }

}
