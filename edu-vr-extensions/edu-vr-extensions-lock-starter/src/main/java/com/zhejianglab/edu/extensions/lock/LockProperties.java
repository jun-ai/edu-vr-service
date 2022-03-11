package com.zhejianglab.edu.extensions.lock;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * 锁配置
 *
 * @author chengwei
 * @since 2021/6/9
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "lock")
public class LockProperties {

    /**
     * 锁策略，默认使用JDK锁
     */
    @NestedConfigurationProperty
    private LockPolicy policy = LockPolicy.JDK;

    /**
     * 锁策略
     */
    public enum LockPolicy {

        /**
         * 基于JDK的锁实现
         */
        JDK,

        /**
         * 基于REDIS的分布式锁实现
         */
        REDIS
    }
}