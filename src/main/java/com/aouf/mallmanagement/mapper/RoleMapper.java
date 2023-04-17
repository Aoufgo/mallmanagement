package com.aouf.mallmanagement.mapper;

import com.aouf.mallmanagement.bean.bo.AddRoleBo;
import com.aouf.mallmanagement.bean.bo.SearchRoleBo;
import com.aouf.mallmanagement.bean.po.Role;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper
public interface RoleMapper {

    List<Role> getAll();
    Page<Role> getRolesByBo(SearchRoleBo searchRoleBo);

    Integer add(AddRoleBo addRoleBo);
    Integer update(AddRoleBo addRoleBo);
    Role getRoleByIdOrName(Integer role_id,String role_name);

    Integer delete(int[] ids);
}
