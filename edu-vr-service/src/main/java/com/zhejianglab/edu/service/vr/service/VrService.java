package com.zhejianglab.edu.service.vr.service;

import com.zhejianglab.edu.model.dto.RoomUserDto;
import com.zhejianglab.edu.model.vo.VrVo;

public interface VrService {

    Boolean createRoom(VrVo vrVo);

    RoomUserDto verifyRole(VrVo vrVo);
}
