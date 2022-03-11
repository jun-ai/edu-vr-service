package com.zhejianglab.edu.extensions.lock;


import com.zhejianglab.edu.model.exception.ClientException;

/**
 * 锁相关异常
 *
 * @author chengwei
 * @since 2021/6/9
 */
public class LockException extends ClientException {
    public LockException() {
    }

    public LockException(String message, Object... args) {
        super(message, args);
    }

    public LockException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }

    public LockException(Throwable cause) {
        super(cause);
    }

    public LockException(Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message, Object... args) {
        super(cause, enableSuppression, writableStackTrace, message, args);
    }
}