package com.aouf.mallmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRoleMapper {
    int insert(Integer admin_id,Integer role_id);

    int deleteByAdminId(Integer admin_id);
}
