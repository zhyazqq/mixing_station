package com.onapage.project.unit.controller;/*
UserController
Zqq
七月
*/

import com.onapage.project.base.error.MyErrorMessage;
import com.onapage.project.base.error.MyExceptionEnums;
import com.onapage.project.base.error.MyRunException;
import com.onapage.project.base.result.GetResult;
import com.onapage.project.security.pojo.SysUser;
import com.onapage.project.security.service.SysUserMapperService;
import com.onapage.project.utils.ResultUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@RequestMapping("/user")
public class UserController {
    @Resource
    SysUserMapperService sysUserService;
    //更改密码
    @RequestMapping(value = "/update/password")
    public GetResult<MyErrorMessage> updateUser(String name, String newPassword, String oldPassword){
        SysUser sysUser = sysUserService.selectByName(name);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(!passwordEncoder.matches(oldPassword,sysUser.getPassword()))       {
            throw new MyRunException(MyExceptionEnums.UPDATE_USER_ERROR);
        }
        String password = passwordEncoder.encode(newPassword);
        sysUser.setUpdateTime(new Date());
        sysUser.setPassword(password);
        sysUser.setUpdateUser(sysUser.getId());
        sysUserService.update(sysUser);
        return ResultUtils.success();
    }
}
