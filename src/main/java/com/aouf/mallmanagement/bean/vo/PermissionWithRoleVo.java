package com.aouf.mallmanagement.bean.vo;

/**
 * 可以判断某个角色是否拥有的权限 视图模型类
 * */
public class PermissionWithRoleVo {

    private Integer permission_id;
    private String permission_name;
    private Integer pid;
    private Integer role_id;

    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
