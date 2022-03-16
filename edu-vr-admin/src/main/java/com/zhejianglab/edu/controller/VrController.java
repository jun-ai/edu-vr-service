package com.zhejianglab.edu.controller;

import com.zhejianglab.edu.model.base.AjaxResult;
import com.zhejianglab.edu.model.base.DataResult;
import com.zhejianglab.edu.model.constants.PlatFormEnum;
import com.zhejianglab.edu.model.dto.RoomUserDto;
import com.zhejianglab.edu.model.vo.VrVo;
import com.zhejianglab.edu.service.VrService;
import com.zhejianglab.edu.starter.auth.user.util.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vr")
@Api(tags = {"VR接口", "VR接口"})
public class VrController {

    @Autowired
    private VrService vrService;

    private static final Logger logger = LoggerFactory.getLogger(VrController.class);

    @PostMapping("verifyRole")
    @ApiOperation(value = "鉴别用户身份",notes = "鉴别用户身份")
    public AjaxResult verifyRole(@RequestBody VrVo vrVo){
        if (StringUtils.isEmpty(vrVo.getUserId())){
            return  AjaxResult.error(PlatFormEnum.PARAMETER_EMPTY.code,PlatFormEnum.getValue(PlatFormEnum.PARAMETER_EMPTY.code),DataResult.success());
        }
        logger.info("鉴别用户身份:{}"+vrVo);
        vrVo.setUserId(SessionUtil.get().getEmpId());
        logger.info("Session鉴别用户身份:{}"+vrVo);
        RoomUserDto roomUserDto = vrService.verifyRole(vrVo);
        return AjaxResult.success(DataResult.success(roomUserDto));
    }
}
