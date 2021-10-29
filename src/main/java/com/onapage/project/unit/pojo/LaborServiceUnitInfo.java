package com.onapage.project.unit.pojo;/*
LaborServiceUnit
Zqq
七月
*/

import com.onapage.project.vo.VO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LaborServiceUnitInfo extends VO {
    //编号
   
    private Integer laborServiceUnitId;
    //法人
    private String legalPerson;
    //公司名称
    private String company;
    //股份占比
    private Float shareProportion;
    //合同编号
    private String contractNumber;
    //公司类型
    private Integer companyType;
}
