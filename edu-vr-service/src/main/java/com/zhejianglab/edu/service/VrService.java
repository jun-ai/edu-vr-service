package com.zhejianglab.edu.service;

import com.zhejianglab.edu.model.dto.RoomUserDto;
import com.zhejianglab.edu.model.vo.VrVo;

public interface VrService {

    RoomUserDto verifyRole(VrVo vrVo);
}
