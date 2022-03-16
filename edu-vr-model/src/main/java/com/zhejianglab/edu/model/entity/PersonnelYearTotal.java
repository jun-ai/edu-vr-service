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
@ApiModel(value = "PersonnelYearTotal对象", description = "人才年度总数表")
public class PersonnelYearTotal implements Serializable {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "类型")
    private String name;

    @ApiModelProperty(value = "值")
    private String value;
}
