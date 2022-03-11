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
@ApiModel("学生相关")
public class StudentReqVo implements Serializable {

    @ApiModelProperty("课程id")
    private String classId;

    @ApiModelProperty("学生id")
    private String studentId;

    @ApiModelProperty("权限标识 0-标识有权限 1-标识无权限")
    private String authFlag;

    @ApiModelProperty("学生姓名")
    private String name;

    public StudentReqVo() {
    }

    public StudentReqVo(String classId, String studentId, String authFlag, String name) {
        this.classId = classId;
        this.studentId = studentId;
        this.authFlag = authFlag;
        this.name = name;
    }
}
