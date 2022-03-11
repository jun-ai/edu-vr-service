package com.zhejianglab.edu.service.vr.service;


import com.zhejianglab.edu.model.vo.StudentReqVo;
import com.zhejianglab.edu.model.vo.TeacherReqVo;
import java.util.List;

public interface TeacherService {

    Boolean authByStuId(TeacherReqVo teacherReqVO);

    Boolean leftRoom(TeacherReqVo teacherReqVO);

    List stuList(TeacherReqVo teacherReqVo);

    Boolean verifyIsLive(TeacherReqVo teacherReqVo);
}
