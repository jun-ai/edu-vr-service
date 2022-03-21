package com.zhejianglab.edu.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "PersonnelEmployNumAndTrend对象", description = "就业人数及就业趋势表")
public class PersonnelEmployNumAndTrend {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "年份")
    private String x;

    @ApiModelProperty(value = "")
    private String y;

    @ApiModelProperty(value = "")
    private String z;
}
