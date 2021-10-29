package com.onapage.project.security.service.impl;/*
SysUserMapperServiceImpl
Zqq
七月
*/

import com.onapage.project.security.pojo.SysUser;
import com.onapage.project.security.mapper.SysUserMapper;
import com.onapage.project.security.service.SysUserMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("sysUserMapperService")
public class SysUserMapperServiceImpl implements SysUserMapperService {
   @Resource
   private SysUserMapper mapper;
    @Override
    public SysUser selectByName(String userName) {
        return mapper.selectByName(userName);
    }

    @Override
    public int update(SysUser sysUser) {
        mapper.update(sysUser);
        return 0;
    }
}
