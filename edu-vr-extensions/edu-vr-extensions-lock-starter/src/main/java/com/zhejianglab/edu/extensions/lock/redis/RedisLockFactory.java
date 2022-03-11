package com.zhejianglab.edu.extensions.lock.redis;

import cn.hutool.core.lang.Assert;
import com.zhejianglab.edu.extensions.lock.AbstractLockFactory;
import org.redisson.api.RedissonClient;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * 基于redis的锁工厂实现
 *
 * @author chengwei
 * @since 2021/6/9
 */
public class RedisLockFactory extends AbstractLockFactory {

    private final RedissonClient redissonClient;

    public RedisLockFactory(RedissonClient redissonClient) {
        Assert.notNull(redissonClient, "redissonClient不能为空");
        this.redissonClient = redissonClient;
    }

    @Override
    protected Lock makeReentrantLock(String lockName) {
        return this.redissonClient.getLock(lockName);
    }

    @Override
    protected ReadWriteLock makeReadWriteLock(String lockName) {
        return this.redissonClient.getReadWriteLock(lockName);
    }
}