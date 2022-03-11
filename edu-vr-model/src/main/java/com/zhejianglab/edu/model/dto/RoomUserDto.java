package com.zhejianglab.edu.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@ApiModel("房间用户")
public class RoomUserDto implements Serializable {

    @ApiModelProperty("课程id")
    private String classId;

    @ApiModelProperty("用户id(教师或者学生id)")
    private String userId;

    @ApiModelProperty("角色id 1-教师身份 2-学生身份")
    private String roleId;

    @ApiModelProperty("权限标识 0-标识有权限 1-标识无权限")
    private String authFlag;

    public RoomUserDto() {
    }

    public RoomUserDto(String classId, String userId, String roleId, String authFlag) {
        this.classId = classId;
        this.userId = userId;
        this.roleId = roleId;
        this.authFlag = authFlag;
    }
}
