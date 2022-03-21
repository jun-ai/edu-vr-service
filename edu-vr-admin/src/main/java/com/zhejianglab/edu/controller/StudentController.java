package com.zhejianglab.edu.controller;

import com.zhejianglab.edu.model.base.AjaxResult;
import com.zhejianglab.edu.model.base.DataResult;
import com.zhejianglab.edu.model.constants.PlatFormEnum;
import com.zhejianglab.edu.model.dto.RoomUserDto;
import com.zhejianglab.edu.model.vo.StudentReqVo;
import com.zhejianglab.edu.service.StudentService;
import com.zhejianglab.edu.starter.auth.user.util.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
@Api(tags = {"学生端接口", "学生端接口"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);


    @PostMapping("leftRoom")
    @ApiOperation(value = "学生退出房间",notes = "学生退出房间")
    public AjaxResult leftRoom(@RequestBody StudentReqVo studentReqVO){
        if (StringUtils.isEmpty(studentReqVO.getStudentId())){
            return  AjaxResult.error(PlatFormEnum.PARAMETER_EMPTY.code,PlatFormEnum.getValue(PlatFormEnum.PARAMETER_EMPTY.code), DataResult.success());
        }
        logger.info("学生退出房间:{}"+studentReqVO);
        studentReqVO.setStudentId(String.valueOf(SessionUtil.get().getZhid()));
        studentService.leftRoom(studentReqVO);
        return AjaxResult.success();
    }

//    @PostMapping("verifyIsLive")
//    @ApiOperation(value = "学生是否还存活",notes = "学生是否还存活")
//    public AjaxResult verifyIsLive(@RequestBody StudentReqVo studentReqVO){
//        if (StringUtils.isEmpty(studentReqVO.getClassId())||StringUtils.isEmpty(studentReqVO.getStudentId())){
//            return  AjaxResult.error(PlatFormEnum.PARAMETER_EMPTY.code,PlatFormEnum.getValue(PlatFormEnum.PARAMETER_EMPTY.code), DataResult.success());
//        }
//        logger.info("学生是否还存活:{}"+studentReqVO);
//        studentService.verifyIsLive(studentReqVO);
//        return AjaxResult.success();
//    }

    @PostMapping("isAuth")
    @ApiOperation(value = "学生是否有权限",notes = "学生是否有权限")
    public AjaxResult isAuth(@RequestBody StudentReqVo studentReqVO){
        if (StringUtils.isEmpty(studentReqVO.getStudentId())){
            return  AjaxResult.error(PlatFormEnum.PARAMETER_EMPTY.code,PlatFormEnum.getValue(PlatFormEnum.PARAMETER_EMPTY.code), DataResult.success());
        }
        logger.info("学生是否有权限:{}"+studentReqVO);
        logger.info("用户id为:{}"+SessionUtil.get().getZhid());
        studentReqVO.setStudentId(String.valueOf(SessionUtil.get().getZhid()));
        RoomUserDto auth = studentService.isAuth(studentReqVO);
        return AjaxResult.success(DataResult.success(auth));
    }
}
