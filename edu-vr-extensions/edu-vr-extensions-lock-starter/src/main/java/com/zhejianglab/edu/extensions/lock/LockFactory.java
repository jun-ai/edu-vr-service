package com.zhejianglab.edu.extensions.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * 锁工厂
 *
 * @author chengwei
 * @since 2021/6/9
 */
public interface LockFactory {

    /**
     * 获取可重入锁（非公平锁）
     *
     * @param lockName 锁名称
     * @return 锁
     */
    Lock getReentrantLock(String lockName);


    /**
     * 获取读写锁
     *
     * @param lockName 锁名称
     * @return 锁
     */
    ReadWriteLock getReadWriteLock(String lockName);
}
