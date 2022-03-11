package com.zhejianglab.edu.service.vr;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@EnableDiscoveryClient
@EnableCaching
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class,scanBasePackages = "com.zhejianglab.edu")
public class VrServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(VrServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VrServiceApplication.class, args);
        log.info("---------------------------职教云VR模块启动成功---------------------------");
    }

}
