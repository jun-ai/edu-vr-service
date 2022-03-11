package com.zhejianglab.edu.service.vr.controller;

import com.zhejianglab.edu.model.base.AjaxResult;
import com.zhejianglab.edu.model.base.DataResult;
import com.zhejianglab.edu.model.constants.PlatFormEnum;
import com.zhejianglab.edu.model.vo.TeacherReqVo;
import com.zhejianglab.edu.service.vr.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("teacher")
@Api(tags = {"老师端接口", "老师端接口"})
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @PostMapping("authByStuId")
    @ApiOperation(value = "老师给学生赋权限",notes = "老师给学生赋权限")
    public AjaxResult authByStuId(@RequestBody TeacherReqVo teacherReqVO){
        if (StringUtils.isEmpty(teacherReqVO.getTeacherId())||StringUtils.isEmpty(teacherReqVO.getStudentId())){
            return  AjaxResult.error(PlatFormEnum.PARAMETER_EMPTY.code,PlatFormEnum.getValue(PlatFormEnum.PARAMETER_EMPTY.code),DataResult.success());
        }
        logger.info("老师给学生赋权限:{}"+teacherReqVO);
        teacherService.authByStuId(teacherReqVO);
        return AjaxResult.success();
    }

    @PostMapping("leftRoom")
    @ApiOperation(value = "老师退出房间",notes = "老师退出房间")
    public AjaxResult leftRoom(@RequestBody TeacherReqVo teacherReqVO) {
        if (StringUtils.isEmpty(teacherReqVO.getClassId())){
            return  AjaxResult.error(PlatFormEnum.PARAMETER_EMPTY.code,PlatFormEnum.getValue(PlatFormEnum.PARAMETER_EMPTY.code),DataResult.success());
        }
        logger.info("老师退出房间:{}" + teacherReqVO);
        Boolean delete = teacherService.leftRoom(teacherReqVO);
        if (delete){
            return AjaxResult.success();
        }else {
            return  AjaxResult.error(PlatFormEnum.LEFT_ROOM_FAIL.code,PlatFormEnum.getValue(PlatFormEnum.LEFT_ROOM_FAIL.code),DataResult.success());
        }
    }

    @RequestMapping(value = "/stuList", method = RequestMethod.POST)
    @ApiOperation(value = "展示学生列表",notes = "展示学生列表")
    public AjaxResult stuList(@RequestBody TeacherReqVo teacherReqVO) {
        if (StringUtils.isEmpty(teacherReqVO.getClassId())){
            return  AjaxResult.error(PlatFormEnum.PARAMETER_EMPTY.code,PlatFormEnum.getValue(PlatFormEnum.PARAMETER_EMPTY.code),DataResult.success());
        }
        logger.info("展示学生列表:{}" + teacherReqVO);
        List list = teacherService.stuList(teacherReqVO);
        return AjaxResult.success(DataResult.success(list));
    }

    @PostMapping("verifyIsLive")
    @ApiOperation(value = "教师是否存活",notes = "教师是否存活")
    public AjaxResult verifyIsLive(@RequestBody TeacherReqVo teacherReqVO) {
        if (StringUtils.isEmpty(teacherReqVO.getTeacherId())){
            return  AjaxResult.error(PlatFormEnum.PARAMETER_EMPTY.code,PlatFormEnum.getValue(PlatFormEnum.PARAMETER_EMPTY.code),DataResult.success());
        }
        logger.info("教师是否存活:{}" + teacherReqVO);
        teacherService.verifyIsLive(teacherReqVO);
        return AjaxResult.success();
    }

}
