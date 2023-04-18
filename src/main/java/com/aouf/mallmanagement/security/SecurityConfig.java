package com.aouf.mallmanagement.security;

import com.aouf.mallmanagement.security.handler.LoginErrorHandle;
import com.aouf.mallmanagement.security.handler.LoginSuccessHandle;
import com.aouf.mallmanagement.security.handler.LogoutSuccessHandle;
import com.aouf.mallmanagement.security.handler.PermissionErrorHandle;
import com.aouf.mallmanagement.service.IAdminService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;

/**
 * SpringSecurity总配置文件
 * */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private IAdminService adminService;

    @Resource
    private PermissionAuthority permissionAuthority;

    @Resource
    private PermissionValid permissionValid;

    @Resource
    private LoginErrorHandle loginErrorHandle;

    @Resource
    private LoginSuccessHandle loginSuccessHandle;

    @Resource
    private LogoutSuccessHandle logoutSuccessHandle;

    @Resource
    private PermissionErrorHandle permissionErrorHandle;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置登录验证方式
        auth.userDetailsService(adminService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 配置例外路径
        web.ignoring().antMatchers("/login","/index/login","/common/**","/img/**","/css/**","/js/**","/favicon.ico")
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/images/**", "/webjars/**", "/v2/api-docs", "/configuration/ui", "/configuration/security");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置Security
        http.headers().frameOptions().disable() // 允许iframe嵌套
                .and()
                .authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(permissionAuthority);   // 授权对象
                        o.setAccessDecisionManager(permissionValid);        // 权限验证对象
                        return o;
                    }
                })
                .and()
                .formLogin()
                .loginPage("/index/login")              // 登录的表单页面
                .loginProcessingUrl("/index/loginDo")   // 登录表单的处理页面
                .usernameParameter("admin_name")        // 账户名称
                .passwordParameter("admin_pass")        // 账户密码
                .failureHandler( loginErrorHandle )     // 登录失败处理器
                .successHandler( loginSuccessHandle )   // 登录成功处理器
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index/logout")             // 安全退出页面
                .logoutSuccessHandler( logoutSuccessHandle )    // 安全退出成功处理器
                .permitAll()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .accessDeniedHandler(permissionErrorHandle);   // 权限验证失败处理器
    }
}
