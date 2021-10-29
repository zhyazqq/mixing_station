package com.onapage.project.security.service.impl;/*
selectListByUserImpl
Zqq
七月
*/

import com.onapage.project.security.pojo.SysPermission;
import com.onapage.project.security.mapper.SysPermissionMapper;
import com.onapage.project.security.service.SysPermissionMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("sysPermissionMapperService")
public class SysPermissionMapperServiceImpl implements SysPermissionMapperService {
   @Resource
   private SysPermissionMapper mapper;
    @Override
    public List<SysPermission> selectListByUser(Integer userId) {
        return  mapper.selectListByUser(userId);

    }

    @Override
    public List<SysPermission> selectListByPath(String path) {
        return  mapper.selectListByPath(path);
    }
}
