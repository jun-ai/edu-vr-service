package com.zhejianglab.edu.impl;

import com.zhejianglab.edu.model.dto.RoomUserDto;
import com.zhejianglab.edu.model.vo.TeacherReqVo;
import com.zhejianglab.edu.service.TeacherService;
import com.zhejianglab.edu.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    WebSocketServer webSocketServer;

    @Override
    public Boolean authByStuId(TeacherReqVo teacherReqVO) {
        RoomUserDto roomUserDto = webSocketServer.sessionPools.get(teacherReqVO.getStudentId());
        roomUserDto.setUserId(teacherReqVO.getStudentId());
        roomUserDto.setRoleId(String.valueOf(2));
        roomUserDto.setAuthFlag(String.valueOf(0));
        //roomUserDto.setSession(session);
        RoomUserDto userDto = webSocketServer.sessionPools.put(teacherReqVO.getStudentId(), roomUserDto);
        if (userDto!=null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean cancelAuthByStuId(TeacherReqVo teacherReqVO) {
        RoomUserDto roomUserDto = webSocketServer.sessionPools.get(teacherReqVO.getStudentId());
        roomUserDto.setUserId(teacherReqVO.getStudentId());
        roomUserDto.setRoleId(String.valueOf(2));
        roomUserDto.setAuthFlag(String.valueOf(1));
        //roomUserDto.setSession(session);
        RoomUserDto userDto = webSocketServer.sessionPools.put(teacherReqVO.getStudentId(), roomUserDto);
        if (userDto!=null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean leftRoom(TeacherReqVo teacherReqVO) {
        Collection<RoomUserDto> roomUserDtoCollection = webSocketServer.sessionPools.values();
        for (RoomUserDto roomUserDto:roomUserDtoCollection){
            webSocketServer.onClose(roomUserDto.getUserId());
        }
        return true;
    }

    @Override
    public List stuList(TeacherReqVo teacherReqVO) {
        List<RoomUserDto> stuList = new ArrayList<RoomUserDto>(webSocketServer.sessionPools.values());
        log.info("学生列表信息为"+stuList);
        return stuList;
    }

    @Override
    public Boolean verifyIsLive(TeacherReqVo teacherReqVo) {
        return null;
    }
}
