package com.zhejianglab.edu.extensions.cache.impl.redis;

import lombok.Getter;
import lombok.Setter;
import org.redisson.config.TransportMode;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Redisson配置属性
 *
 * @author chengwei
 * @since 2021/6/7
 */
@Getter
@Setter
public class RedissonProperties {

    /**
     * redis服务端host，默认为localhost
     */
    private String host = "localhost";

    /**
     * redis服务端端口，默认为6379
     */
    private int port = 6379;

    /**
     * database，默认为0
     */
    private int database = 0;

    /**
     * 认证密码，默认为空
     */
    private String password;

    /**
     * 连接超时时间（秒），默认10秒
     */
    private Long timeout = 10L;

    /**
     * 是否开启SSL，默认不开启
     */
    private boolean ssl = false;

    /**
     * 线程池数量，默认值 = 当前处理核数量 * 2
     */
    private int threads;

    /**
     * Netty线程池数量，默认值 = 当前处理核数量 * 2
     */
    private int nettyThreads;

    /**
     * 传输模式
     */
    private TransportMode transportMode;

    /**
     * 单机服务配置
     */
    @NestedConfigurationProperty
    private SingleServerConfig singleServerConfig;

    @Getter
    @Setter
    public static class SingleServerConfig {

        /**
         * 客户端名称
         */
        private String clientName;

        /**
         * 最小空闲连接数
         */
        private int connectionMinimumIdleSize;

        /**
         * 连接池大小
         */
        private int connectionPoolSize;

        /**
         * 连接空闲超时，单位：毫秒
         */
        private int idleConnectionTimeout;

        /**
         * 命令等待超时，单位：毫秒
         */
        private int timeout;

        /**
         * 如果尝试在此限制之内发送成功，则开始启用 timeout 计时。
         */
        private int retryAttempts;

        /**
         * 命令重试发送时间间隔，单位：毫秒
         */
        private int retryInterval;

        /**
         * 发布和订阅连接的最小空闲连接数
         */
        private int subscriptionConnectionMinimumIdleSize;

        /**
         * 发布和订阅连接池大小
         */
        private int subscriptionConnectionPoolSize;

        /**
         * 单个连接最大订阅数量
         */
        private int subscriptionsPerConnection;

        /**
         * DNS监测时间间隔，单位：毫秒
         */
        private int dnsMonitoringInterval;
    }
}
