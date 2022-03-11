package com.zhejianglab.edu.extensions.lock;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.SimpleCache;
import cn.hutool.core.lang.func.Func0;

import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * 抽象的锁工厂，提供获取锁的模板方法。
 * <p>
 * 注：{@link SimpleCache}基于{@link WeakHashMap}实现，因此可以自动清理锁缓存。
 *
 * @author chengwei
 * @since 2021/6/21
 */
public abstract class AbstractLockFactory implements LockFactory {

    /**
     * 可重入锁缓存，key为锁名，value为具体的锁
     */
    private final SimpleCache<String, Lock> reentrantLockCache = new SimpleCache<>();

    /**
     * 读写锁缓存，key为锁名，value为具体的锁
     */
    private final SimpleCache<String, ReadWriteLock> readWriteLockCache = new SimpleCache<>();

    @Override
    public Lock getReentrantLock(String lockName) {
        Assert.notEmpty(lockName, "锁名称不能为空");
        return this.reentrantLockCache.get(lockName, (Func0<Lock>) () -> makeReentrantLock(lockName));
    }

    @Override
    public ReadWriteLock getReadWriteLock(String lockName) {
        Assert.notEmpty(lockName, "锁名称不能为空");
        return this.readWriteLockCache.get(lockName, (Func0<ReadWriteLock>) () -> makeReadWriteLock(lockName));
    }

    /**
     * 创建可重入锁
     *
     * @return 可重入锁
     */
    protected abstract Lock makeReentrantLock(String lockName);

    /**
     * 创建读写锁
     *
     * @return 读写锁
     */
    protected abstract ReadWriteLock makeReadWriteLock(String lockName);
}