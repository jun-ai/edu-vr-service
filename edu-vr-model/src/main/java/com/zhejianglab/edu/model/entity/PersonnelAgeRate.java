package com.zhejianglab.edu.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@ApiModel(value = "PersonnelAgeRate对象", description = "人才年龄阶段占比表")
public class PersonnelAgeRate implements Serializable {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "类型-X坐标")
    private String x;

    @ApiModelProperty(value = "比例-Y坐标")
    private String y;

    @ApiModelProperty(value = "半径")
    private String r;

    @ApiModelProperty(value = "行业类型")
    private String s;
}
