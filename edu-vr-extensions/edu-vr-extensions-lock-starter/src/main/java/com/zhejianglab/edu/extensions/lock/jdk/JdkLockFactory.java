package com.zhejianglab.edu.extensions.lock.jdk;


import com.zhejianglab.edu.extensions.lock.AbstractLockFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 基于JDK的锁工厂实现
 *
 * @author chengwei
 * @since 2021/6/9
 */
public class JdkLockFactory extends AbstractLockFactory {

    @Override
    protected Lock makeReentrantLock(String lockName) {
        return new ReentrantLock();
    }

    @Override
    protected ReadWriteLock makeReadWriteLock(String lockName) {
        return new ReentrantReadWriteLock();
    }
}