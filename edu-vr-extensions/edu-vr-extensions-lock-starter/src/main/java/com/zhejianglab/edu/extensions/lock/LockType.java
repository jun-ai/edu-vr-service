package com.zhejianglab.edu.extensions.lock;

/**
 * 锁类型
 *
 * @author chengwei
 * @since 2021/6/9
 */
public enum LockType {

    /**
     * 可重入锁
     */
    REENTRANT,

    /**
     * 读锁
     */
    READ,

    /**
     * 写锁
     */
    WRITE
}