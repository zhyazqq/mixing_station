package com.onapage.project.unit.controller;/*
LaborServiceUnitController
Zqq
七月
*/

import com.onapage.project.base.error.MyErrorMessage;
import com.onapage.project.base.result.GetResult;
import com.onapage.project.base.result.GetResultInfo;
import com.onapage.project.unit.pojo.Ids;
import com.onapage.project.unit.pojo.LaborServiceUnitInfo;
import com.onapage.project.unit.service.ILaborServiceUnitInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api
//@CrossOrigin
public class LaborServiceUnitController {
    @Resource
    private ILaborServiceUnitInfo serviceUnitInfo;
    @RequestMapping(value = "/query/pagenum/{pageNum}/pagesize/{pageSize}",method = RequestMethod.GET)
    public GetResultInfo<?> query(@PathVariable(name = "pageSize") Integer pageSize,@PathVariable(name = "pageNum") Integer pageNum){
        return serviceUnitInfo.query(pageSize,pageNum);
    }
    @RequestMapping(value = "/query/condition",method = RequestMethod.GET)
    public GetResultInfo<?> queryByCondition(@RequestParam(name = "pageSize") Integer pageSize,
                                             @RequestParam(name = "pageNum") Integer pageNum,
                                             @RequestParam(name = "name",required = false) String name,
                                             @RequestParam(name = "company",required = false) String company ,
                                             @RequestParam(name = "companyType",required = false) Integer companyType
    ){
        return serviceUnitInfo.queryByCondition(pageSize,pageNum,name,company,companyType);
    }
    @RequestMapping(value = "/add/labor/service/unit",method = RequestMethod.POST)
    public GetResult<MyErrorMessage> add(@RequestBody LaborServiceUnitInfo req){

        return serviceUnitInfo.add(req);
    }

    @RequestMapping(value = "/update/labor/service/unit",method = RequestMethod.PUT)
    public GetResult<MyErrorMessage> update(@RequestBody LaborServiceUnitInfo req){
        return serviceUnitInfo.update(req);
    }
    @RequestMapping(value = "/delete/labor/service/unit",method = RequestMethod.POST)
    public GetResult<MyErrorMessage> delete(@RequestBody Ids id){
        return serviceUnitInfo.delete(id.getId());
    }
}
