package com.onapage.project.security.service.impl;

import com.onapage.project.security.pojo.SysPermission;
import com.onapage.project.security.pojo.SysUser;
import com.onapage.project.security.service.SysPermissionMapperService;
import com.onapage.project.security.service.SysUserMapperService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
//@Service("userDetailsService")
public class UserDetailsServiceImpl  implements UserDetailsService {
    @Resource
    private SysUserMapperService sysUserService;
    @Resource
    private SysPermissionMapperService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //需要构造出 org.springframework.security.core.userdetails.User 对象并返回
        if (username == null || "".equals(username)) {
            throw new RuntimeException("用户不能为空");
        }
        //根据用户名查询用户
        SysUser sysUser = sysUserService.selectByName(username);
        if (sysUser == null) {
            throw new RuntimeException("用户不存在");
        }
        
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (sysUser != null) {
            //获取该用户所拥有的权限
            List<SysPermission> sysPermissions = sysPermissionService.selectListByUser(sysUser.getId());
            // 声明用户授权
            sysPermissions.forEach(sysPermission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getPermissionCode());
                grantedAuthorities.add(grantedAuthority);
            });
        }
        return new User(sysUser.getUserName(),
                sysUser.getPassword(),
                true,
                true,
                true,
                true,
                grantedAuthorities);
    }
}
