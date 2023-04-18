package com.aouf.mallmanagement.mapper;

import com.aouf.mallmanagement.bean.bo.AddRoleBo;
import com.aouf.mallmanagement.bean.bo.SearchRoleBo;
import com.aouf.mallmanagement.bean.po.Role;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
@Mapper
public interface RoleMapper {

    List<Role> getAll();
    Page<Role> getRolesByBo(SearchRoleBo searchRoleBo);

    Integer add(AddRoleBo addRoleBo);
    Integer update(AddRoleBo addRoleBo);
    Role getRoleByIdOrName(Integer role_id,String role_name);

    Integer delete(int[] ids);
    // 根据 访问的资源路径 获取 可以访问的角色列表
    List<Role> getListByOperateUrl(@Param("operate_url") String operate_url );
}
