package com.onapage.project.unit.mapper;

import com.onapage.project.unit.pojo.LaborServiceUnitInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface LaborServiceUnitInfoMapper {
    /**
     *  新增
     * @param req
     * @return   返回结果
     */
    int add(LaborServiceUnitInfo req);

    /**
     *  更新数据
     * @param req              
     * @return   返回结果
     */
    int update(LaborServiceUnitInfo req);

    /**
     * 查询数据
     * @param
     * @return  返回结果
     */
    List<LaborServiceUnitInfo> query();
    
    List<LaborServiceUnitInfo> queryByCondition(String name,String company,Integer companyType);

    /**
     *  删除
     * @param id id     i
     * @return 结果     j
     */
    int delete( List<Integer> id);
}
