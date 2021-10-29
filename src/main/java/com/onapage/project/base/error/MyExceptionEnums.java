package com.onapage.project.base.error;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 */
public enum MyExceptionEnums implements MyException {
    /**
     *
     */
    USERNAME_ERROR(1, "用户名不能为空", new Date(System.currentTimeMillis())),
	PASSWORD_ERROR(2, "密码不能为空", new Date(System.currentTimeMillis())),
	USERNAME_LENGTH_ERROR(3, "用户名长度不能小于3", new Date(System.currentTimeMillis())),
	PASSWORD_LENGTH_ERROR(4, "密码长度不能小于3", new Date(System.currentTimeMillis())),
	DELETE_ID_NOT_EXIST(5, "请选择一条数据", new Date(System.currentTimeMillis())),
	USER_HAS_BEEN_EXIST(6, "用户名已存在", new Date(System.currentTimeMillis())),
	INSERT_ERROR(7, "新增数据失败", new Date(System.currentTimeMillis())),
	UPDATE_ERROR(8, "更新数据失败", new Date(System.currentTimeMillis())),
	DELETE_ERROR(9, "删除数据失败", new Date(System.currentTimeMillis())),
    UPDATE_USER_ERROR(10, "原始密码错误", new Date(System.currentTimeMillis())),
	;

	private Integer code;
	private String message;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;

	MyExceptionEnums(Integer code, String message, Date date) {
		this.code = code;
		this.message = message;
		this.date = date;

	}



	public MyRunException toException(Object... args) {
		return new MyRunException(this,args);
	}



	@Override
	public Integer getCode() {
		// TODO Auto-generated method stub
		return this.code;
	}



	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}



	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return this.date;
	}
}
