package com.onapage.project.unit.service;/*
ILaborServiceUnitInfo
Zqq
七月
*/

import com.onapage.project.base.error.MyErrorMessage;
import com.onapage.project.base.result.GetResult;
import com.onapage.project.base.result.GetResultInfo;
import com.onapage.project.unit.pojo.LaborServiceUnitInfo;

import java.util.List;

public interface ILaborServiceUnitInfo {


    /**
     * 查询
     * @return                   结果集
     */
    GetResultInfo<?> query(Integer pageSize,Integer PageNum);
    GetResultInfo<?> queryByCondition(Integer pageSize,Integer PageNum,String name,String company,Integer companyType);

    /**
     * 新增
     * @param req 参数
     * @return  返回
     */
    GetResult<MyErrorMessage> add(LaborServiceUnitInfo req);

    /**
     * 更新
     * @param req 项目
     * @return 返回
     */
    GetResult<MyErrorMessage> update(LaborServiceUnitInfo req);


    GetResult<MyErrorMessage> delete(List<Integer> ids);
}
