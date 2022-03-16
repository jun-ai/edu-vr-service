package com.zhejianglab.edu.service;

import com.zhejianglab.edu.model.dto.RoomUserDto;
import com.zhejianglab.edu.model.vo.StudentReqVo;

public interface StudentService {

    void leftRoom(StudentReqVo studentReqVO);

    Boolean verifyIsLive(StudentReqVo studentReqVo);

    RoomUserDto isAuth(StudentReqVo studentReqVo);
}
