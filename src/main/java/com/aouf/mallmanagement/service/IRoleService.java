package com.aouf.mallmanagement.service;

import com.aouf.mallmanagement.bean.bo.AddRoleBo;
import com.aouf.mallmanagement.bean.bo.SearchRoleBo;
import com.aouf.mallmanagement.bean.po.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IRoleService {
    List<Role> getAll();
    PageInfo<Role> getRolesByBo(SearchRoleBo searchRoleBo);
    String add (AddRoleBo addRoleBo);
    String update (AddRoleBo addRoleBo);
    Role getRoleByIdOrName(Integer role_id, String role_name);

    String delete(int[] ids);
}

