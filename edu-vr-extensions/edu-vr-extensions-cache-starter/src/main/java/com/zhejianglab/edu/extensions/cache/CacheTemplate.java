package com.zhejianglab.edu.extensions.cache;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * 缓存接口
 *
 * @author chengwei
 * @since 2021/6/9
 */
public interface CacheTemplate {

    /**
     * 根据缓存键插入缓存值，默认永不过期
     *
     * @param key   缓存键
     * @param value 缓存值
     * @param <T>   缓存值类型
     */
    <T> void setCacheObject(String key, T value);

    /**
     * 根据缓存键插入缓存值并设置超时时间
     *
     * @param key      缓存键
     * @param value    缓存值
     * @param timeout  超时时间
     * @param timeUnit 超时时间单位
     * @param <T>      缓存值类型
     */
    <T> void setCacheObject(String key, T value, long timeout, TimeUnit timeUnit);

    /**
     * 根据缓存键获取缓存值
     *
     * @param key 缓存键
     * @param <T> 缓存值类型
     * @return 缓存值
     */
    <T> T getCacheObject(String key);

    /**
     * 根据缓存键获取缓存值，若缓存值不存在则从{@code cacheLoader}中加载后缓存
     *
     * @param key         缓存键
     * @param cacheLoader 缓存加载器
     * @param <T>         缓存值类型
     * @return 缓存值
     */
    <T> T getCacheObject(String key, Function<String, T> cacheLoader);

    /**
     * 根据缓存键获取缓存值并设置超时时间，若缓存值不存在则从{@code cacheLoader}中加载后缓存
     *
     * @param key         缓存键
     * @param cacheLoader 缓存加载器
     * @param timeout     超时时间
     * @param timeUnit    超时时间单位
     * @param <T>         缓存值类型
     * @return 缓存值
     */
    <T> T getCacheObject(String key, Function<String, T> cacheLoader, long timeout, TimeUnit timeUnit);

    /**
     * 根据缓存键删除缓存值
     *
     * @param key 缓存键
     */
    void deleteCacheObject(String key);

    /**
     * 设置缓存过期时间
     *
     * @param key      缓存键
     * @param timeout  超时时间
     * @param timeUnit 超时时间单位
     */
    void expire(String key, long timeout, TimeUnit timeUnit);
}
