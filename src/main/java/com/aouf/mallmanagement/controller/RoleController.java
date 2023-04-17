package com.aouf.mallmanagement.controller;

import com.aouf.mallmanagement.bean.bo.AddRoleBo;
import com.aouf.mallmanagement.bean.bo.SearchRoleBo;
import com.aouf.mallmanagement.bean.po.Role;
import com.aouf.mallmanagement.service.IPermissionService;
import com.aouf.mallmanagement.service.IRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    private IRoleService roleService;
    private IPermissionService permissionService;
    @Autowired
    public void setPermissionService(IPermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Autowired
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/list")
    public String admin(Model model, SearchRoleBo searchRoleBo){
        PageInfo<Role> rolePageInfo = roleService.getRolesByBo(searchRoleBo);
        model.addAttribute("roles",rolePageInfo.getList());
        model.addAttribute("searchRoleBo",searchRoleBo);
        model.addAttribute("pageCount", rolePageInfo.getPages());
        model.addAttribute("page",searchRoleBo.getPage());
        model.addAttribute("pageSize",searchRoleBo.getPageSize());
        return null;
    }

    @RequestMapping("/add")
    public String add(Model model){
        // 添加权限信息
        model.addAttribute("permissions",permissionService.getAll());
        return null;
    }
    @RequestMapping("/save")
    @ResponseBody
    public String save(AddRoleBo addRoleBo){
        return roleService.add(addRoleBo);
    }

    @RequestMapping("/validName")
    @ResponseBody
    public String validName(String role_name){
        return (roleService.getRoleByIdOrName(null,role_name)==null) ? "false":"true";
    }

    @RequestMapping("/edit")
    public String edit(Model model,Integer role_id){
        // 角色信息
        model.addAttribute("permissions",permissionService.getAll());
        model.addAttribute("role",roleService.getRoleByIdOrName(role_id,null));
        return null;
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(AddRoleBo addRoleBo){
        return roleService.update(addRoleBo);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam(value = "ids[]") int[] ids){
        return roleService.delete(ids);
    }


}
