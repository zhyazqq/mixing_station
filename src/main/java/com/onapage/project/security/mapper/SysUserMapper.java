package com.onapage.project.security.mapper;

import com.onapage.project.security.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {
    SysUser selectByName(String userName);
    int update(SysUser sysUser);

}
