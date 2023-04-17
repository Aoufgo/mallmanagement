package com.aouf.mallmanagement.bean.bo;

//实体类-负责用户的登录业务
public class User {
    //成员属性
    private String username;    //登录名
    private String password;    //登录密码

    //访问器

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
