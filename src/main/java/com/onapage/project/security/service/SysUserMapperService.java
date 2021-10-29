package com.onapage.project.security.service;/*
SysUserMapperService
Zqq
七月
*/


import com.onapage.project.security.pojo.SysUser;

public interface SysUserMapperService {
    SysUser selectByName(String userName);
    int update(SysUser sysUser);
}
