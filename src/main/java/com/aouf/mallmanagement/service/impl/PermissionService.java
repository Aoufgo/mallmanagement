package com.aouf.mallmanagement.service.impl;

import com.aouf.mallmanagement.bean.po.Permission;
import com.aouf.mallmanagement.mapper.PermissionMapper;
import com.aouf.mallmanagement.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionService implements IPermissionService {
    private PermissionMapper permissionMapper;
    @Autowired
    public void setPermissionMapper(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<Permission> getAll() {
        return permissionMapper.getAll();
    }
}
