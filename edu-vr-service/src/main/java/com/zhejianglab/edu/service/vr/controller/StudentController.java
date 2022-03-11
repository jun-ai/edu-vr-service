package com.zhejianglab.edu.service.vr.controller;

import com.zhejianglab.edu.model.base.AjaxResult;
import com.zhejianglab.edu.model.base.DataResult;
import com.zhejianglab.edu.model.constants.PlatFormEnum;
import com.zhejianglab.edu.model.vo.StudentReqVo;
import com.zhejianglab.edu.service.vr.service.StudentService;
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
        if (StringUtils.isEmpty(studentReqVO.getClassId())||StringUtils.isEmpty(studentReqVO.getStudentId())){
            return  AjaxResult.error(PlatFormEnum.PARAMETER_EMPTY.code,PlatFormEnum.getValue(PlatFormEnum.PARAMETER_EMPTY.code), DataResult.success());
        }
        logger.info("学生退出房间:{}"+studentReqVO);
        studentService.leftRoom(studentReqVO);
        return AjaxResult.success();
    }

    @PostMapping("verifyIsLive")
    @ApiOperation(value = "学生是否还存活",notes = "学生是否还存活")
    public AjaxResult verifyIsLive(@RequestBody StudentReqVo studentReqVO){
        if (StringUtils.isEmpty(studentReqVO.getClassId())||StringUtils.isEmpty(studentReqVO.getStudentId())){
            return  AjaxResult.error(PlatFormEnum.PARAMETER_EMPTY.code,PlatFormEnum.getValue(PlatFormEnum.PARAMETER_EMPTY.code), DataResult.success());
        }
        logger.info("学生是否还存活:{}"+studentReqVO);
        studentService.verifyIsLive(studentReqVO);
        return AjaxResult.success();
    }

}
