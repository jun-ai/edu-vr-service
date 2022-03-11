package com.zhejianglab.edu.service.vr.service;

import com.zhejianglab.edu.model.vo.StudentReqVo;

public interface StudentService {

    Boolean leftRoom(StudentReqVo studentReqVO);

    Boolean verifyIsLive(StudentReqVo studentReqVo);
}
