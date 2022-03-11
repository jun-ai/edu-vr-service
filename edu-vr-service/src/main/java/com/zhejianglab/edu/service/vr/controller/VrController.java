package com.zhejianglab.edu.service.vr.controller;

import com.zhejianglab.edu.model.base.AjaxResult;
import com.zhejianglab.edu.model.base.DataResult;
import com.zhejianglab.edu.model.constants.PlatFormEnum;
import com.zhejianglab.edu.model.vo.VrVo;
import com.zhejianglab.edu.service.vr.service.VrService;
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

    @RequestMapping(value = "/createRoom", method = RequestMethod.POST)
    @ApiOperation(value = "创建/加入房间",notes = "创建/加入房间")
    public AjaxResult createRoom(@RequestBody  VrVo vrVo){
        if (StringUtils.isEmpty(vrVo.getClassId())||StringUtils.isEmpty(vrVo.getUserId())){
            return  AjaxResult.error(PlatFormEnum.PARAMETER_EMPTY.code,PlatFormEnum.getValue(PlatFormEnum.PARAMETER_EMPTY.code),DataResult.success());
        }
        logger.info("创建房间:{}"+vrVo);
        Boolean room = vrService.createRoom(vrVo);
        if (room){
            return AjaxResult.success();
        }else {
            return  AjaxResult.error(PlatFormEnum.CREATE_ROOM_FAIL.code,PlatFormEnum.getValue(PlatFormEnum.CREATE_ROOM_FAIL.code),DataResult.success());
        }
    }

    @PostMapping("verifyRole")
    @ApiOperation(value = "鉴别用户身份",notes = "鉴别用户身份")
    public AjaxResult verifyRole(@RequestBody VrVo vrVo){
        if (StringUtils.isEmpty(vrVo.getClassId())||StringUtils.isEmpty(vrVo.getUserId())){
            return  AjaxResult.error(PlatFormEnum.PARAMETER_EMPTY.code,PlatFormEnum.getValue(PlatFormEnum.PARAMETER_EMPTY.code),DataResult.success());
        }
        logger.info("鉴别用户身份:{}"+vrVo);
        vrService.verifyRole(vrVo);
        return AjaxResult.success();
    }

}
