package com.zhejianglab.edu.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "PersonnelGpReq对象", description = "人才缺口需求表")
public class PersonnelGpReq {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "颜色分类")
    private Integer colorField;

    @ApiModelProperty(value = "类型-X坐标")
    private String x;

    @ApiModelProperty(value = "比例-Y坐标")
    private String y;
}
