package com.zhejianglab.edu.service.vr.service.impl;

import com.zhejianglab.edu.model.dto.RoomUserDto;
import com.zhejianglab.edu.model.vo.StudentReqVo;
import com.zhejianglab.edu.model.vo.TeacherReqVo;
import com.zhejianglab.edu.service.vr.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Boolean authByStuId(TeacherReqVo teacherReqVO) {
        ListOperations opsForList = redisTemplate.opsForList();
        Long size = opsForList.size(teacherReqVO.getClassId());
        List<RoomUserDto> roomUserDtoList = opsForList.range(teacherReqVO.getClassId(), 0, size - 1);
        for (RoomUserDto userDto:roomUserDtoList){
            if (userDto.getUserId().equals(teacherReqVO.getStudentId())){
                userDto.setAuthFlag(String.valueOf(0));
            }else return false;
        }

        return true;
    }

    @Override
    public Boolean leftRoom(TeacherReqVo teacherReqVO) {
        Boolean delete = redisTemplate.delete(teacherReqVO.getClassId());
        return delete;
    }

    @Override
    public List stuList(TeacherReqVo teacherReqVO) {
        ListOperations opsForList = redisTemplate.opsForList();
        Long size = opsForList.size(teacherReqVO.getClassId());
        log.info("房间总人数为:{}"+size);
        List<RoomUserDto> roomUserDtoList = opsForList.range(teacherReqVO.getClassId(), 0, size - 1);
        return roomUserDtoList;
    }

    @Override
    public Boolean verifyIsLive(TeacherReqVo teacherReqVo) {
        return null;
    }
}
