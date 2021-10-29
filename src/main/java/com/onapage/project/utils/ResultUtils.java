package com.onapage.project.utils;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.onapage.project.base.error.MyErrorMessage;
import com.onapage.project.base.paging.PagingInfo;
import com.onapage.project.base.result.GetResult;
import com.onapage.project.base.result.GetResultInfo;
import com.onapage.project.base.result.GetResultInfoPaging;
import com.onapage.project.base.result.Result;
import com.onapage.project.vo.VO;

public class ResultUtils {
	private static final Integer CODE_400=400;
	private static final Integer CODE_200=200;
	private static final String MSG_OK="success";
	private static final String MSG_FAIL="fail";
	private static final Date date=new Date(System.currentTimeMillis());
	private static final boolean success=true;

	
	
public static <T extends VO> Result<T> fail(T data){
	Result<T> result =new Result<T>();
	result.setCode(CODE_400);
	result.setMessage(MSG_FAIL);
	result.setDate(date);
	result.setData(data);
	return result;
}
public static <T extends VO> Result<T> fail(){
	Result<T> result =new Result<T>();
	result.setCode(CODE_400);
	result.setMessage(MSG_FAIL);
	result.setDate(date);
	return result;
}
public static <T extends VO> GetResult<MyErrorMessage> success(){
	GetResult<MyErrorMessage> result=new GetResult<MyErrorMessage>();
	result.setCode(CODE_200);
	result.setMessage(MSG_OK);
	result.setDate(date);
	result.setSuccess(success);
	return result;
}
public static <T extends VO> GetResultInfo<T> resultInfo(List<T> list){
	GetResultInfo<T> resultInfo =new GetResultInfo<T>();
	resultInfo.setList(list);
	resultInfo.setCode(CODE_200);
	resultInfo.setMessage(MSG_OK);
	resultInfo.setDate(date);
	resultInfo.setSuccess(success);
	return resultInfo;
}
public static <T extends VO> GetResultInfo<T> resultInfo(Map<String,Object> map){
	GetResultInfo<T> resultInfo =new GetResultInfo<T>();
//	resultInfo.setList(list);
	resultInfo.setCode(CODE_200);
	resultInfo.setMap(map);
	resultInfo.setMessage(MSG_OK);
	resultInfo.setDate(date);
	resultInfo.setSuccess(success);
	return resultInfo;
}
public static <T extends VO> GetResultInfo<T> resultPagingInfo(PagingInfo paging,List<T> list){
	GetResultInfoPaging<T> resultInfo =new GetResultInfoPaging<T>();
	resultInfo.setList(list);
	resultInfo.setCode(CODE_200);
	resultInfo.setMessage(MSG_OK);
	resultInfo.setDate(date);
	resultInfo.setSuccess(success);
	resultInfo.setPaging(paging);
	return resultInfo;
}
}
