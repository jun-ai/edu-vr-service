package com.zhejianglab.edu.extensions.lock;

import cn.hutool.core.lang.func.Func0;
import cn.hutool.core.lang.func.VoidFunc0;

import java.util.concurrent.TimeUnit;

/**
 * 锁接口
 *
 * @author chengwei
 * @since 2021/6/9
 */
public interface LockTemplate {

    /**
     * 使用可重入锁锁住当前调用者线程指定的某项操作
     *
     * @param lockName  锁名称
     * @param operation 操作
     * @param <T>       返回值类型泛型
     * @return 操作的返回值
     */
    <T> T lockByReentrantLock(String lockName, Func0<T> operation);

    /**
     * 使用可重入锁锁住当前调用者线程指定的某项操作
     *
     * @param lockName  锁名称
     * @param operation 操作
     */
    default void lockByReentrantLock(String lockName, VoidFunc0 operation) {
        this.lockByReentrantLock(lockName, () -> {
            operation.call();
            return null;
        });
    }

    /**
     * 使用可重入锁锁住当前调用者线程指定的某项操作
     *
     * @param lockName       锁名称
     * @param operation      操作
     * @param expireTime     超时时间
     * @param expireTimeUnit 超时时间单位
     * @param <T>            返回值类型泛型
     * @return 操作的返回值
     */
    <T> T tryLockByReentrantLock(String lockName, Func0<T> operation, long expireTime, TimeUnit expireTimeUnit);

    /**
     * 使用可重入锁锁住当前调用者线程指定的某项操作
     *
     * @param lockName       锁名称
     * @param operation      操作
     * @param expireTime     超时时间
     * @param expireTimeUnit 超时时间单位
     */
    default void tryLockByReentrantLock(String lockName, VoidFunc0 operation, long expireTime, TimeUnit expireTimeUnit) {
        this.tryLockByReentrantLock(lockName, () -> {
            operation.call();
            return null;
        }, expireTime, expireTimeUnit);
    }

    /**
     * 使用读锁锁住当前调用者线程指定的某项操作
     *
     * @param lockName  锁名称
     * @param operation 操作
     * @param <T>       返回值类型泛型
     * @return 操作的返回值
     */
    <T> T lockByReadLock(String lockName, Func0<T> operation);

    /**
     * 使用读锁锁住当前调用者线程指定的某项操作
     *
     * @param lockName       锁名称
     * @param operation      操作
     * @param expireTime     超时时间
     * @param expireTimeUnit 超时时间单位
     * @param <T>            返回值类型泛型
     * @return 操作的返回值
     */
    <T> T tryLockByReadLock(String lockName, Func0<T> operation, long expireTime, TimeUnit expireTimeUnit);

    /**
     * 使用写锁锁住当前调用者线程指定的某项操作
     *
     * @param lockName  锁名称
     * @param operation 操作
     * @param <T>       返回值类型泛型
     * @return 操作的返回值
     */
    <T> T lockByWriteLock(String lockName, Func0<T> operation);

    /**
     * 使用写锁锁住当前调用者线程指定的某项操作
     *
     * @param lockName       锁名称
     * @param operation      操作
     * @param expireTime     超时时间
     * @param expireTimeUnit 超时时间单位
     * @param <T>            返回值类型泛型
     * @return 操作的返回值
     */
    <T> T tryLockByWriteLock(String lockName, Func0<T> operation, long expireTime, TimeUnit expireTimeUnit);
}
