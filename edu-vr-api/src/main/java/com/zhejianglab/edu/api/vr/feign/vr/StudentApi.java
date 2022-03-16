package com.zhejianglab.edu.api.vr.feign.vr;


import com.zhejianglab.edu.model.base.AjaxResult;
import com.zhejianglab.edu.model.vo.StudentReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "edu-vr-service")
public interface StudentApi {

    @PostMapping("student/leftRoom")
    public AjaxResult leftRoom(@RequestBody StudentReqVo studentReqVO);

    @PostMapping("student/isAuth")
    public AjaxResult isAuth(@RequestBody StudentReqVo studentReqVO);
}
