package com.onapage.project.security.mapper;

import com.onapage.project.security.pojo.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysPermissionMapper {
    List<SysPermission> selectListByUser(Integer userId);
    List<SysPermission> selectListByPath(String path);
}
