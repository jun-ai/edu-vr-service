package com.zhejianglab.edu.extensions.cache;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.zhejianglab.edu.extensions.cache.impl.redis.RedisCacheTemplate;
import com.zhejianglab.edu.extensions.cache.impl.redis.RedissonProperties;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.codec.JsonJacksonCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.TimeZone;

/**
 * 缓存自动化配置，目前只实现了基于redis的缓存。
 *
 * @author chengwei
 * @since 2021/6/7
 */
@Configuration
@EnableConfigurationProperties(CacheProperties.class)
public class CacheAutoConfiguration {

    /**
     * 默认协议，不开启SSL
     */
    private static final String DEFAULT_PROTOCOL_PREFIX = "redis://";

    /**
     * 开启SSL
     */
    private static final String SSL_PROTOCOL_PREFIX = "rediss://";

    /**
     * 将RedissonClient注入到IOC容器
     */
    @Bean
    @ConditionalOnMissingBean(RedissonClient.class)
    public RedissonClient redissonClient(CacheProperties cacheProperties) {
        RedissonProperties redissonProperties = cacheProperties.getRedisson();
        String prefix = DEFAULT_PROTOCOL_PREFIX;
        if (redissonProperties.isSsl()) {
            prefix = SSL_PROTOCOL_PREFIX;
        }
        Config config = new Config();
        config.setThreads(redissonProperties.getThreads())
                .setNettyThreads(redissonProperties.getNettyThreads())
                .setTransportMode(redissonProperties.getTransportMode());

        // 序列化方式
        ObjectMapper objectMapper = this.getObjectMapper();
        Codec codec = new JsonJacksonCodec(objectMapper);
        config.setCodec(codec);

        // 默认为单节点模式
        RedissonProperties.SingleServerConfig singleServerConfig = redissonProperties.getSingleServerConfig();
        config.useSingleServer()
                .setAddress(prefix + redissonProperties.getHost() + ":" + redissonProperties.getPort())
                .setConnectTimeout((int) Duration.ofSeconds(redissonProperties.getTimeout()).toMillis())
                .setDatabase(redissonProperties.getDatabase())
                .setPassword(StrUtil.isNotBlank(redissonProperties.getPassword()) ? redissonProperties.getPassword() : null)
                .setTimeout(singleServerConfig.getTimeout())
                .setRetryAttempts(singleServerConfig.getRetryAttempts())
                .setRetryInterval(singleServerConfig.getRetryInterval())
                .setSubscriptionsPerConnection(singleServerConfig.getSubscriptionsPerConnection())
                .setClientName(singleServerConfig.getClientName())
                .setIdleConnectionTimeout(singleServerConfig.getIdleConnectionTimeout())
                .setSubscriptionConnectionMinimumIdleSize(singleServerConfig.getSubscriptionConnectionMinimumIdleSize())
                .setSubscriptionConnectionPoolSize(singleServerConfig.getSubscriptionConnectionPoolSize())
                .setConnectionMinimumIdleSize(singleServerConfig.getConnectionMinimumIdleSize())
                .setConnectionPoolSize(singleServerConfig.getConnectionPoolSize())
                .setDnsMonitoringInterval(singleServerConfig.getDnsMonitoringInterval());
        return Redisson.create(config);
    }

    /**
     * 将缓存模板注入到IOC容器
     */
    @Bean
    public CacheTemplate cacheTemplate(RedissonClient redissonClient, CacheProperties cacheProperties) {
        return new RedisCacheTemplate(redissonClient, cacheProperties.getDefaultCacheTime());
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        objectMapper.setDateFormat(new SimpleDateFormat(DatePattern.NORM_DATETIME_PATTERN));
        return objectMapper;
    }
}
