package com.zhejianglab.edu.api.vr.feign;

import com.zhejianglab.edu.api.vr.bean.FeignRequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "edu-vr-service",
        contextId = "StudentFeign", configuration = FeignRequestInterceptor.class)
public interface StudentFeign {

    String API_PREFIX = "/student";
}
