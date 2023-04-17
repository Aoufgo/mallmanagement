package com.aouf.mallmanagement.service.impl;

import com.aouf.mallmanagement.bean.bo.AddAdminBo;
import com.aouf.mallmanagement.bean.bo.AddRoleBo;
import com.aouf.mallmanagement.bean.bo.SearchRoleBo;
import com.aouf.mallmanagement.bean.po.Permission;
import com.aouf.mallmanagement.bean.po.Role;
import com.aouf.mallmanagement.mapper.RoleMapper;
import com.aouf.mallmanagement.mapper.RolePermissionMapper;
import com.aouf.mallmanagement.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
@Service
public class RoleService implements IRoleService {
    private RoleMapper roleMapper;
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    public void setRolePermissionMapper(RolePermissionMapper rolePermissionMapper) {
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }


    @Override
    public List<Role> getAll() {
        return roleMapper.getAll();
    }
    @Override
    public PageInfo<Role> getRolesByBo(SearchRoleBo searchRoleBo) {
        // 使用分页插件
        PageHelper.startPage(searchRoleBo.getPage(), searchRoleBo.getPageSize());
        return new PageInfo<>(roleMapper.getRolesByBo(searchRoleBo));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String add(AddRoleBo addRoleBo) {
        // 添加角色
        try {
            if (roleMapper.add(addRoleBo) > 0) {
                Integer[] idList = addRoleBo.getId_list();
                for (Integer id : idList) {
                    rolePermissionMapper.insert(addRoleBo.getRole_id(),id);
                }
                return "添加成功";
            }else {
                return  "添加失败";
            }
        }catch (Exception e){
            // 可以在出现异常回滚时设置返回值
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return "添加失败";
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String update(AddRoleBo addRoleBo) {
        // 获取用户信息
        String curRoleName = roleMapper.getRoleByIdOrName(addRoleBo.getRole_id(),null).getRole_name();
        String role_name = addRoleBo.getRole_name();
        // 如果用户名修改了则验证是否有相同用户名,二次验证*
        if(curRoleName.equals(role_name) || roleMapper.getRoleByIdOrName(null,role_name)==null){
            // 更新用户信息
            if (roleMapper.update(addRoleBo)>0){
                // 删除用户角色信息
                rolePermissionMapper.deleteByRoleId(addRoleBo.getRole_id());
                // 添加用户角色信息
                Integer[] permission_ids = addRoleBo.getId_list();
                for(Integer permissions_id: permission_ids){
                    rolePermissionMapper.insert(addRoleBo.getRole_id(),permissions_id);
                }
            }
            return "角色更新成功";
        }else {
            return "角色名已存在!更新失败";
        }
    }

    @Override
    public Role getRoleByIdOrName(Integer role_id, String role_name) {
        return roleMapper.getRoleByIdOrName(role_id,role_name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String delete(int[] ids) {
        try {
            // 删除角色
            if (roleMapper.delete(ids) > 0) {
                // 删除对应权限信息
                for (int id : ids) {
                    rolePermissionMapper.deleteByRoleId(id);
                }
                return "删除成功";
            } else {
                return "删除失败";
            }
        } catch (Exception e){
            // 可以在出现异常回滚时设置返回值
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return "删除失败";
        }
    }

}
