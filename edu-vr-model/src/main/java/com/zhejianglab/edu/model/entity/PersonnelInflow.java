package com.zhejianglab.edu.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "PersonnelInflow对象", description = "人才流入表")
public class PersonnelInflow {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "领域")
    private String area;

    @ApiModelProperty(value = "最高值")
    private String pv;

    @ApiModelProperty(value = "最低值")
    private String min;

    @ApiModelProperty(value = "平均值")
    private String pj;

    @ApiModelProperty(value = "当前值")
    private String now;

}
