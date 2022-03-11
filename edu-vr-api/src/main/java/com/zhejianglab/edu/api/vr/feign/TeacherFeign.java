package com.zhejianglab.edu.api.vr.feign;

import com.zhejianglab.edu.api.vr.bean.FeignRequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "edu-vr-service",
        contextId = "TeacherFeign", configuration = FeignRequestInterceptor.class)
public interface TeacherFeign {

    String API_PREFIX = "/teacher";
}
