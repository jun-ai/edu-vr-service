package com.zhejianglab.edu.model.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "PersonnelReqSupplyRate对象", description = "行业人才需求与供应占比表")
public class PersonnelReqSupplyRate {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "需求占比/供应占比")
    private String x;

    @ApiModelProperty(value = "行业")
    private String y;

    @ApiModelProperty(value = "类型")
    private String s;
}
