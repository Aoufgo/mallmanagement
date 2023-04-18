package com.aouf.mallmanagement.service.impl;

import com.aouf.mallmanagement.bean.bo.AddAdminBo;
import com.aouf.mallmanagement.bean.bo.SearchAdminBo;
import com.aouf.mallmanagement.bean.po.Admin;
import com.aouf.mallmanagement.bean.po.Role;
import com.aouf.mallmanagement.mapper.AdminMapper;
import com.aouf.mallmanagement.mapper.AdminRoleMapper;
import com.aouf.mallmanagement.service.IAdminService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
@Service

public class AdminService implements IAdminService {
    private AdminMapper adminMapper;
    private AdminRoleMapper adminRoleMapper;
    @Autowired
    public void setAdminRoleMapper(AdminRoleMapper adminRoleMapper) {
        this.adminRoleMapper = adminRoleMapper;
    }

    @Autowired
    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public List<Admin> getAdminsByBo(SearchAdminBo searchAdminBo) {
        return adminMapper.getAdminsByBo(searchAdminBo);
    }

    @Override
    public Integer getAdminsByBoCount(SearchAdminBo searchAdminBo) {
        return adminMapper.getAdminsByBoCount(searchAdminBo);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String delete(int[] ids) {
        try {

            if (adminMapper.delete(ids) > 0) {
                for (int id : ids) {
                    adminRoleMapper.deleteByAdminId(id);
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String add(AddAdminBo addAdminBo) {
        try {
            // 验证是否有相同用户名
            String admin_name = addAdminBo.getAdmin_name();
            if (adminMapper.getAdminByIdOrName(null, admin_name) == null) {
                // 设置密码
                addAdminBo.setAdmin_pass("123123123");
                // 添加用户
                if (adminMapper.add(addAdminBo) > 0) {
                    // 添加用户角色信息
                    List<Role> roles = addAdminBo.getRoles();
                    for (Role role : roles) {
                        adminRoleMapper.insert(addAdminBo.getAdmin_id(), role.getRole_id());
                    }
                }
                return "用户添加成功";
            } else {
                return "用户名已存在!添加失败";
            }
        } catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return "添加失败";
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String update(AddAdminBo addAdminBo) {
        // 获取用户信息
        String curAdmin_name = adminMapper.getAdminByIdOrName(addAdminBo.getAdmin_id(),null).getAdmin_name();
        String admin_name = addAdminBo.getAdmin_name();
        // 如果用户名修改了则验证是否有相同用户名
        if(curAdmin_name.equals(admin_name) || adminMapper.getAdminByIdOrName(null,admin_name)==null){
            // 更新用户信息
            if (adminMapper.update(addAdminBo)>0){
                // 删除用户角色信息
                adminRoleMapper.deleteByAdminId(addAdminBo.getAdmin_id());
                // 添加用户角色信息
                List<Role> roles = addAdminBo.getRoles();
                for(Role role: roles){
                    adminRoleMapper.insert(addAdminBo.getAdmin_id(),role.getRole_id());
                }
            }
            return "用户更新成功";
        }else {
            return "用户名已存在!更新失败";
        }
    }

    @Override
    public Admin getAdminByIdOrName(Integer admin_id, String admin_name) {
        return adminMapper.getAdminByIdOrName(admin_id,admin_name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtil.isEmpty(username)){
            throw new UsernameNotFoundException("用户名为空!");
        }
        Admin admin = adminMapper.getAdminByIdOrName(null, username );
        if( admin == null ){
            throw new UsernameNotFoundException("账户名称或密码错误！请重新填写！");
        }
        return admin;
    }
}
