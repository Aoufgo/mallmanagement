package com.aouf.mallmanagement.bean.po;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

//实体类-负责角色
public class Role implements GrantedAuthority {
    //成员属性
    private Integer role_id;        //角色编号
    private String role_name;       //角色名称
    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", permissions=" + permissions +
                '}';
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
    //访问器

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String getAuthority() {
        return getRole_name();
    }


    //toString方法的重写

}
