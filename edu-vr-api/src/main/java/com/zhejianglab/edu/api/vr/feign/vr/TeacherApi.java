package com.zhejianglab.edu.api.vr.feign.vr;


import com.zhejianglab.edu.model.base.AjaxResult;
import com.zhejianglab.edu.model.vo.TeacherReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "edu-vr-service")
public interface TeacherApi {

    @PostMapping("teacher/authByStuId")
    public AjaxResult authByStuId(@RequestBody TeacherReqVo teacherReqVO);

    @PostMapping("teacher/leftRoom")
    public AjaxResult leftRoom(@RequestBody TeacherReqVo teacherReqVO);

    @PostMapping(value = "teacher/stuList")
    public AjaxResult stuList(@RequestBody TeacherReqVo teacherReqVO);

    @PostMapping("teacher/cancelAuthByStuId")
    public AjaxResult cancelAuthByStuId(@RequestBody TeacherReqVo teacherReqVO);
}
