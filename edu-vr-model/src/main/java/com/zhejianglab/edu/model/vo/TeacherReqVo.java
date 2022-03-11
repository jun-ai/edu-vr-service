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
@ApiModel("教师相关")
public class TeacherReqVo implements Serializable {

    @ApiModelProperty("课程id")
    private String classId;

    @ApiModelProperty("教师id")
    private String teacherId;

    @ApiModelProperty("学生id")
    private String studentId;

    public TeacherReqVo() {
    }

    public TeacherReqVo(String classId, String teacherId, String studentId) {
        this.classId = classId;
        this.teacherId = teacherId;
        this.studentId = studentId;
    }
}
