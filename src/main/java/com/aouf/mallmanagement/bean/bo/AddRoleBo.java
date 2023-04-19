package com.aouf.mallmanagement.bean.bo;

import com.aouf.mallmanagement.bean.po.Permission;
import com.aouf.mallmanagement.bean.po.Role;

import java.util.Arrays;
import java.util.List;

public class AddRoleBo {
    private Integer role_id;
    private String role_name;
    private Integer[] id_list = new Integer[10];


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

    public Integer[] getId_list() {
        return id_list;
    }

    public void setId_list(Integer[] id_list) {
        this.id_list = id_list;
    }

    @Override
    public String toString() {
        return "AddRoleBo{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", id_list=" + Arrays.toString(id_list) +
                '}';
    }
}


