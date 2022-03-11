package com.zhejianglab.edu.extensions.cache;


import com.zhejianglab.edu.extensions.cache.impl.redis.RedissonProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * 缓存配置
 *
 * @author chengwei
 * @since 2021/6/17
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "cache")
public class CacheProperties {

    /**
     * 默认缓存时间，单位分，默认值7 * 24 * 60，即7天
     */
    private long defaultCacheTime = 7 * 24 * 60;

    /**
     * redisson配置
     */
    @NestedConfigurationProperty
    private RedissonProperties redisson;
}