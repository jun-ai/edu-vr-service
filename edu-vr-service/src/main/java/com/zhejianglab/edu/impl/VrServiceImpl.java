package com.zhejianglab.edu.impl;

import com.zhejianglab.edu.model.dto.RoomUserDto;
import com.zhejianglab.edu.model.vo.VrVo;
import com.zhejianglab.edu.service.VrService;
import com.zhejianglab.edu.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VrServiceImpl implements VrService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private WebSocketServer webSocketServer;


    @Override
    public RoomUserDto verifyRole(VrVo vrVo) {
        RoomUserDto roomUserDto = webSocketServer.sessionPools.get(vrVo.getUserId());
        return roomUserDto;
    }
}
