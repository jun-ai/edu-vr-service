package com.zhejianglab.edu.model.exception;

/**
 * 客户端异常
 *
 * @author chengwei
 * @since 2021/6/24
 */
public class ClientException extends TemplatedRuntimeException {
    public ClientException() {
    }

    public ClientException(String message, Object... args) {
        super(message, args);
    }

    public ClientException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }

    public ClientException(Throwable cause) {
        super(cause);
    }

    public ClientException(Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message, Object... args) {
        super(cause, enableSuppression, writableStackTrace, message, args);
    }
}