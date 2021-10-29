package com.onapage.project.security.config;

import com.onapage.project.security.pojo.SysPermission;
import com.onapage.project.security.service.SysPermissionMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Component
public class CustomizeFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Resource
    SysPermissionMapperService sysPermissionService;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        String split = requestUrl.split("\\?")[0];
//        antPathMatcher.match()
        //查询具体某个接口的权限
//        List<SysPermission> permissionList =  sysPermissionService.selectListByPath(requestUrl);
        List<SysPermission> permissionList =  sysPermissionService.selectListByPath(split);
        if(permissionList == null || permissionList.size() == 0){
            //请求路径没有配置权限，表明该请求接口可以任意访问
//            antPathMatcher.match()
            return null;
        }
        String[] attributes = new String[permissionList.size()];
        for(int i = 0;i<permissionList.size();i++){
            attributes[i] = permissionList.get(i).getPermissionCode();
        }
        return SecurityConfig.createList(attributes);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}