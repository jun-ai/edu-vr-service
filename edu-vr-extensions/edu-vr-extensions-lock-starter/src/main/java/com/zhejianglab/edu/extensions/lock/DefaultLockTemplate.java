package com.zhejianglab.edu.extensions.lock;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.func.Func0;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * 锁模板的默认实现
 *
 * @author chengwei
 * @since 2021/6/9
 */
public class DefaultLockTemplate implements LockTemplate {

    private final LockFactory lockFactory;

    public DefaultLockTemplate(LockFactory lockFactory) {
        this.lockFactory = lockFactory;
    }

    @Override
    public <T> T lockByReentrantLock(String lockName, Func0<T> operation) {
        return this.doLockOperation(LockType.REENTRANT, lockName, operation);
    }

    @Override
    public <T> T tryLockByReentrantLock(String lockName, Func0<T> operation, long expireTime, TimeUnit expireTimeUnit) {
        return this.doTryLockOperation(LockType.REENTRANT, lockName, operation, expireTime, expireTimeUnit);
    }

    @Override
    public <T> T lockByReadLock(String lockName, Func0<T> operation) {
        return this.doLockOperation(LockType.READ, lockName, operation);
    }

    @Override
    public <T> T tryLockByReadLock(String lockName, Func0<T> operation, long expireTime, TimeUnit expireTimeUnit) {
        return this.doTryLockOperation(LockType.READ, lockName, operation, expireTime, expireTimeUnit);
    }

    @Override
    public <T> T lockByWriteLock(String lockName, Func0<T> operation) {
        return this.doLockOperation(LockType.WRITE, lockName, operation);
    }

    @Override
    public <T> T tryLockByWriteLock(String lockName, Func0<T> operation, long expireTime, TimeUnit expireTimeUnit) {
        return this.doTryLockOperation(LockType.WRITE, lockName, operation, expireTime, expireTimeUnit);
    }

    /**
     * 根据锁类型和锁名获取锁后进行加锁，然后执行{@code operation}中的操作，最后释放锁。
     *
     * @param type           锁类型
     * @param lockName       锁名
     * @param operation      操作
     * @param expireTime     过期时间
     * @param expireTimeUnit 过期时间单位
     * @param <T>            返回值类型泛型
     * @return {@code operation}返回值
     */
    private <T> T doTryLockOperation(LockType type,
                                     String lockName,
                                     Func0<T> operation,
                                     long expireTime,
                                     TimeUnit expireTimeUnit) {
        Lock lock = this.getLock(type, lockName);
        Assert.state(expireTime > 0, "过期时间必须>0");
        Assert.notNull(expireTimeUnit, "过期时间单位不能为空");
        try {
            boolean success = lock.tryLock(expireTime, expireTimeUnit);
            if (!success) {
                throw new LockException("获取锁资源失败");
            }
        } catch (InterruptedException e) {
            throw new LockException("获取锁资源失败");
        }
        try {
            return operation.callWithRuntimeException();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 根据锁类型和锁名获取锁后进行加锁，然后执行{@code operation}中的操作，最后释放锁。
     *
     * @param lockType  锁类型
     * @param lockName  锁名
     * @param operation 操作
     * @param <T>       返回值类型泛型
     * @return {@code operation}返回值
     */
    private <T> T doLockOperation(LockType lockType, String lockName, Func0<T> operation) {
        Lock lock = this.getLock(lockType, lockName);
        lock.lock();
        try {
            return operation.callWithRuntimeException();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 从工厂中获取锁
     *
     * @param lockType 锁类型
     * @param lockName 锁名
     * @return 锁
     */
    private Lock getLock(LockType lockType, String lockName) {
        switch (lockType) {
            case READ:
                return this.lockFactory.getReadWriteLock(lockName).readLock();
            case WRITE:
                return this.lockFactory.getReadWriteLock(lockName).writeLock();
            case REENTRANT:
            default:
                return this.lockFactory.getReentrantLock(lockName);
        }
    }
}