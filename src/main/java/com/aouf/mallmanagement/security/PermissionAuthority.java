package com.aouf.mallmanagement.security;


import com.aouf.mallmanagement.bean.po.Role;
import com.aouf.mallmanagement.mapper.RoleMapper;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 授权类
 * 当用户访问一个资源路径时  如何给该资源路径 授予权限
 * */
@Component
public class PermissionAuthority implements FilterInvocationSecurityMetadataSource {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        // 获取请求的URL
        String requestUrl = ( (FilterInvocation) object ).getRequestUrl();
        // 判断请求的URL是否含有？（参数）
        if(requestUrl.contains("?")) {
            // 将请求的URL去掉参数部分
            requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
        }
        System.out.println(" 当前需要授权的URL = " + requestUrl );
        // 根据URL获取可以访问角色列表
        List<Role> roleList = roleMapper.getListByOperateUrl(requestUrl);
        System.out.println( " 当前需要授权的URL的授权列表 = " + roleList.size() );
        // 判断角色列表是否为空
        if(!roleList.isEmpty()){
            // 准备数组存放授权列表
            String[] roles = new String[roleList.size()];
            // 循环角色列表中的每一个元素
            for( int i = 0 ; i <= roles.length - 1; i++ ){
                // 将当前循环到角色存放到授权列表中
                roles[i] = roleList.get(i).getRole_name();
                System.out.println(" 授权 => " + roleList.get(i).getRole_name() );
            }
            // 返回授权列表
            return SecurityConfig.createList(roles);
        }
        // 避免返回null（任何角色都能访问）
        System.out.println(" 当前访问的页面是公开页面，不需要权限验证！ ");
        return SecurityConfig.createList("PublicPermission");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
