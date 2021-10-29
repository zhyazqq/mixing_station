package com.onapage.project.unit.service.Impl;/*
LaborServiceUnitInfoImpl
Zqq
七月
*/

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.onapage.project.base.error.MyErrorMessage;
import com.onapage.project.base.error.MyExceptionEnums;
import com.onapage.project.base.error.MyRunException;
import com.onapage.project.base.paging.PagingInfo;
import com.onapage.project.base.result.GetResult;
import com.onapage.project.base.result.GetResultInfo;
import com.onapage.project.unit.mapper.LaborServiceUnitInfoMapper;
import com.onapage.project.unit.pojo.LaborServiceUnitInfo;
import com.onapage.project.unit.service.ILaborServiceUnitInfo;
import com.onapage.project.utils.ResultUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LaborServiceUnitInfoImpl implements ILaborServiceUnitInfo {
    @Resource
    private LaborServiceUnitInfoMapper mapper;

    //分页查询数据
    @Override
    public GetResultInfo<?> query(Integer pageSize,Integer PageNum) {

        PageHelper.startPage(PageNum, pageSize);
        List<LaborServiceUnitInfo> resultList = mapper.query();
        PageInfo<LaborServiceUnitInfo> info = new PageInfo<LaborServiceUnitInfo>(resultList);
        PagingInfo paging =new PagingInfo();
        paging.setPageNum(PageNum);
        paging.setPageSize(pageSize);
        paging.setTotal(info.getTotal());
        paging.setPageCount(info.getPages());
        return ResultUtils.resultPagingInfo( paging,info.getList());
    }

    @Override
    public GetResultInfo<?> queryByCondition(Integer pageSize, Integer PageNum, String name, String company,Integer companyType) {
        PageHelper.startPage(PageNum, pageSize);
        List<LaborServiceUnitInfo> resultList = mapper.queryByCondition(name,company,companyType);
        PageInfo<LaborServiceUnitInfo> info = new PageInfo<>(resultList);
        PagingInfo paging =new PagingInfo();
        paging.setPageNum(PageNum);
        paging.setPageSize(pageSize);
        paging.setTotal(info.getTotal());
        paging.setPageCount(info.getPages());

        return ResultUtils.resultPagingInfo( paging,info.getList());
    }

    //添加数据
    @Override
    public GetResult<MyErrorMessage> add(LaborServiceUnitInfo req) {
        int i = mapper.add(req);
        if(i!=1){
            throw new MyRunException(MyExceptionEnums.INSERT_ERROR);
        }
        return ResultUtils.success();
    }

    @Override
    public GetResult<MyErrorMessage> update(LaborServiceUnitInfo req) {
        int i = mapper.update(req);
        if(i!=1){
            throw new MyRunException(MyExceptionEnums.UPDATE_ERROR);
        }
        return ResultUtils.success();
    }

    @Override
    public GetResult<MyErrorMessage> delete(List<Integer> ids) {
        try{
            mapper.delete(ids);
        }catch (Exception e) {
            throw new MyRunException(MyExceptionEnums.DELETE_ERROR);
        }

        return ResultUtils.success();

    }

}
