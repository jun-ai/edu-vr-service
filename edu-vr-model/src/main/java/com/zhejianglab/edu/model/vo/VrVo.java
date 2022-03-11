package com.zhejianglab.edu.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@ApiModel("VR相关")
public class VrVo implements Serializable {

    @ApiModelProperty("课程id")
    private String classId;

    @ApiModelProperty("用户id")
    private String userId;

    public VrVo() {
    }

    public VrVo(String classId, String userId) {
        this.classId = classId;
        this.userId = userId;
    }
}
