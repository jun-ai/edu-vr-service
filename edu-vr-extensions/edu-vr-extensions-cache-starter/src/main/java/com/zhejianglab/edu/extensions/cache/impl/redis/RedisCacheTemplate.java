package com.zhejianglab.edu.extensions.cache.impl.redis;

import cn.hutool.core.lang.Assert;
import com.zhejianglab.edu.extensions.cache.CacheTemplate;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * 基于Redis的缓存实现
 *
 * @author chengwei
 * @since 2021/6/9
 */

public class RedisCacheTemplate implements CacheTemplate {

    private final RedissonClient redissonClient;

    /**
     * 默认缓存时间
     */
    private final long defaultCacheTime;

    /**
     * 默认缓存时间单位
     */
    private final TimeUnit defaultCacheTimeUnit = TimeUnit.MINUTES;


    public RedisCacheTemplate(RedissonClient redissonClient, long defaultCacheTime) {
        Assert.notNull(redissonClient, "redissonClient不能为空");
        Assert.isTrue(defaultCacheTime > 0, "默认超时时间必须大于0");
        this.redissonClient = redissonClient;
        this.defaultCacheTime = defaultCacheTime;
    }

    @Override
    public <T> void setCacheObject(String key, T value) {
        Assert.notEmpty(key, "缓存键不能为空");

        this.setCacheObject(key, value, defaultCacheTime, defaultCacheTimeUnit);
    }

    @Override
    public <T> void setCacheObject(String key, T value, long timeout, TimeUnit timeUnit) {
        Assert.notEmpty(key, "缓存键不能为空");
        Assert.state(timeout > 0, "超时时间必须大于0");
        Assert.notNull(timeout, "超时时间单位不能为空");

        redissonClient.getBucket(key).set(value, timeout, timeUnit);
    }

    @Override
    public <T> T getCacheObject(String key) {
        Assert.notEmpty(key, "缓存键不能为空");

        RBucket<T> result = redissonClient.getBucket(key);
        return result.get();
    }

    @Override
    public <T> T getCacheObject(String key, Function<String, T> cacheLoader) {
        Assert.notEmpty(key, "缓存键不能为空");
        Assert.notNull(cacheLoader, "缓存加载器不能为空");

        return this.getCacheObject(key, cacheLoader, defaultCacheTime, defaultCacheTimeUnit);
    }

    @Override
    public <T> T getCacheObject(String key, Function<String, T> cacheLoader, long timeout, TimeUnit timeUnit) {
        Assert.notEmpty(key, "缓存键不能为空");
        Assert.notNull(cacheLoader, "缓存加载器不能为空");
        Assert.state(timeout > 0, "超时时间必须大于0");
        Assert.notNull(timeout, "超时时间单位不能为空");

        T result = this.getCacheObject(key);
        if (result == null) {
            result = cacheLoader.apply(key);
            if (result != null) {
                this.setCacheObject(key, result, timeout, timeUnit);
            }
        }
        return result;
    }

    @Override
    public void deleteCacheObject(String key) {
        Assert.notEmpty(key, "缓存键不能为空");

        redissonClient.getBucket(key).delete();
    }

    @Override
    public void expire(String key, long timeout, TimeUnit timeUnit) {
        Assert.state(timeout > 0, "超时时间必须大于0");
        Assert.notNull(timeout, "超时时间单位不能为空");

        redissonClient.getBucket(key).expire(timeout, timeUnit);
    }
}