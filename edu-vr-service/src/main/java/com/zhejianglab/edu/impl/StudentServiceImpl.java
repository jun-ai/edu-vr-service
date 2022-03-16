package com.zhejianglab.edu.impl;

import com.zhejianglab.edu.model.dto.RoomUserDto;
import com.zhejianglab.edu.model.vo.StudentReqVo;
import com.zhejianglab.edu.service.StudentService;
import com.zhejianglab.edu.websocket.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private WebSocketServer webSocketServer;

    @Override
    public void leftRoom(StudentReqVo studentReqVO) {
        webSocketServer.onClose(studentReqVO.getStudentId());
    }

    @Override
    public Boolean verifyIsLive(StudentReqVo studentReqVo) {
        return null;
    }

    @Override
    public RoomUserDto isAuth(StudentReqVo studentReqVo) {
        RoomUserDto roomUserDto = webSocketServer.sessionPools.get(studentReqVo.getStudentId());
        log.info("学生权限信息为:{}"+roomUserDto);
        return roomUserDto;
    }
}
