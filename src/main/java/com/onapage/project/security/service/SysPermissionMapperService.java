package com.onapage.project.security.service;

import com.onapage.project.security.pojo.SysPermission;

import java.util.List;

public interface SysPermissionMapperService {
    /**
     * 查询用户的权限列表
     *
     * @param userId
     * @return
     */
    List<SysPermission> selectListByUser(Integer userId);
    List<SysPermission> selectListByPath(String path);
}
