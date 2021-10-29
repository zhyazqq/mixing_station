package com.onapage.project.base.error;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onapage.project.base.result.GetResult;

@ControllerAdvice
public class MyControllerAdvice {
	private static final boolean success=false;
	@ResponseBody
	@ExceptionHandler(value = MyRunException.class)
	public GetResult<MyErrorMessage> exceptionHandler(MyRunException ex) {
		GetResult<MyErrorMessage> result = new GetResult<MyErrorMessage>();
		result.setCode(ex.getMyErrorMessage().getCode());
		result.setDate(ex.getMyErrorMessage().getDate());
		result.setMessage(ex.getMyErrorMessage().getMessage());
		result.setSuccess(success);
		// 发生异常进行日志记录，写入数据库或者其他处理，此处省略
		return result;
	}
}
