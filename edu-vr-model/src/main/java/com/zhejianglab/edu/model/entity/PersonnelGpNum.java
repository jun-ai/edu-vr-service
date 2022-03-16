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
@ApiModel(value = "PersonnelGpNum对象", description = "人才缺口数量表")
public class PersonnelGpNum implements Serializable {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "人才缺口数量类型")
    private String content;

    @ApiModelProperty(value = "人才缺口数量")
    private Integer value;

}
