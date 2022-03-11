package com.zhejianglab.edu.service.vr.service.impl;

import com.zhejianglab.edu.model.dto.RoomUserDto;
import com.zhejianglab.edu.model.vo.VrVo;
import com.zhejianglab.edu.service.vr.service.VrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class VrServiceImpl implements VrService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Boolean createRoom(VrVo vrVo) {
        BoundListOperations listOperations = redisTemplate.boundListOps(vrVo.getClassId());
        RoomUserDto roomUserDto=new RoomUserDto();
        if (listOperations.size()>0){
            //加入房间
            List<RoomUserDto> roomUserDtoList=new ArrayList<>();
            roomUserDto=new RoomUserDto();
            roomUserDto.setClassId(vrVo.getClassId());
            roomUserDto.setUserId(vrVo.getUserId());
            roomUserDto.setRoleId(String.valueOf(2));
            roomUserDto.setAuthFlag(String.valueOf(1));
            roomUserDtoList.add(roomUserDto);
            redisTemplate.opsForList().leftPush(vrVo.getClassId(),roomUserDto);
            //设置过期时间
            redisTemplate.expire(vrVo.getClassId(),40, TimeUnit.MINUTES);
        }else {
            //创建房间
            List<RoomUserDto> roomUserDtoList=new ArrayList<>();
            roomUserDto.setClassId(vrVo.getClassId());
            roomUserDto.setUserId(vrVo.getUserId());
            roomUserDto.setRoleId(String.valueOf(1));
            roomUserDto.setAuthFlag(String.valueOf(0));
            roomUserDtoList.add(roomUserDto);
            redisTemplate.opsForList().leftPush(vrVo.getClassId(),roomUserDto);
            //设置过期时间
            redisTemplate.expire(vrVo.getClassId(),40, TimeUnit.MINUTES);
        }
        return true;
    }

    @Override
    public RoomUserDto verifyRole(VrVo vrVo) {
        return null;
    }
}
