package com.aouf.mallmanagement.controller;

import com.aouf.mallmanagement.bean.bo.AddAdminBo;
import com.aouf.mallmanagement.bean.bo.SearchAdminBo;
import com.aouf.mallmanagement.bean.po.Admin;
import com.aouf.mallmanagement.service.IAdminService;
import com.aouf.mallmanagement.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//视图类-负责员工 ,响应所有/admin/**的用户请求
@RequestMapping("/admin")
@Controller                 //托管给spring框架
public class AdminController {
    private IRoleService roleService;
    private IAdminService adminService;
    @Autowired
    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    @Autowired
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    //视图方法,响应/admin/admin的请求
    @RequestMapping("/admin")
    public String admin(Model model, SearchAdminBo searchAdminBo){
        model.addAttribute("roles",roleService.getAll());
        List<Admin> adminsByBo = adminService.getAdminsByBo(searchAdminBo);
        model.addAttribute("admins",adminsByBo);
        model.addAttribute("searchAdminBo", searchAdminBo);
        model.addAttribute("pageCount",(int)Math.ceil((float)adminService.getAdminsByBoCount(searchAdminBo)/ searchAdminBo.getPageSize()));
        model.addAttribute("page", searchAdminBo.getPage());
        model.addAttribute("pageSize", searchAdminBo.getPageSize());

        return "/admin/list";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam(value = "ids[]") int[] ids){
        return adminService.delete(ids);
    }

    @RequestMapping("/add")
    public String add(Model model){
        // 角色信息
        model.addAttribute("roles",roleService.getAll());
        return null;
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save(AddAdminBo addAdminBo){
        return adminService.add(addAdminBo);
    }

    @RequestMapping("/edit")
    public String edit(Model model,Integer admin_id){
        // 角色信息
        model.addAttribute("roles",roleService.getAll());
        // 创建一个查询对象
        SearchAdminBo searchAdminBo = new SearchAdminBo();
        searchAdminBo.setAdmin_id(admin_id);
        model.addAttribute("admin",adminService.getAdminsByBo(searchAdminBo).get(0));
        return null;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(AddAdminBo addAdminBo){
        return adminService.update(addAdminBo);
    }
}
