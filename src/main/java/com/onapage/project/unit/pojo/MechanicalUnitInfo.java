package com.onapage.project.unit.pojo;/*
MechanicalUnitInfo
Zqq
七月
*/

import com.onapage.project.vo.VO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MechanicalUnitInfo extends VO {
    //编号
    private Integer mechanicalUnitId;
    //法人
    private String legalPerson;
    //公司名称
    private String company;
    //股份占比
    private Float shareProportion;
    //合同编号
    private String contractNumber;
    
}
