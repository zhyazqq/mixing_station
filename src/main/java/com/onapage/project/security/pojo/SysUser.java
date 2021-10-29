package com.onapage.project.security.pojo;/*
User
Zqq
七月
*/

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

@Data
//@Component
public class SysUser  {
    /*
    *   <if test="account != null and account != ''">
                account = #{account},
            </if>
            <if test="userName != null and userName != ''">
                user_name = #{userName},
            </if>
            <if test="password != null and password != ''">
                password = #{password},
            </if>
            <if test="lastLoginTime != null">
                last_login_time = #{lastLoginTime},
            </if>
            <if test="enabled != null">
                enabled = #{enabled},
            </if>
            <if test="accountNonExpired != null">
                account_non_expired = #{accountNonExpired},
            </if>
            <if test="accountNonLocked != null">
                account_non_locked = #{accountNonLocked},
            </if>
            <if test="credentialsNonExpired != null">
                credentials_non_expired = #{credentialsNonExpired},
            </if>
            <if test="createTime != null">
                create_time = #{createTime},
            </if>
            <if test="updateTime != null">
                update_time = #{updateTime},
            </if>
            <if test="createUser != null">
                create_user = #{createUser},
            </if>
            <if test="updateUser != null">
                update_user = #{updateUser},
            </if>
    *
    * */
    private Integer id;
    private String account;
    private String userName;
    private String password;
    @JsonFormat(pattern = "yyyy-HH-mm HH:mm:ss")

    private Date lastLoginTime;
    private Integer enabled;
    private Integer accountNonExpired;
    private Integer accountNonLocked;
    private Integer credentialsNonExpired;
    @JsonFormat(pattern = "yyyy-HH-mm HH:mm:ss")

    private Date createTime;
    @JsonFormat(pattern = "yyyy-HH-mm HH:mm:ss")
    private Date updateTime;
    private Integer createUser;
    private Integer updateUser;

}
