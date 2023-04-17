package com.aouf.mallmanagement.mapper;

import com.aouf.mallmanagement.bean.po.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    List<Permission> getAll();
}
