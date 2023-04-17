package com.aouf.mallmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePermissionMapper {
    Integer insert(Integer role_id,Integer permission_id);
    Integer deleteByRoleId(Integer role_id);
}
