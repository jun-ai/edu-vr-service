package com.zhejianglab.edu.model.exception;

/**
 * 服务端异常
 *
 * @author chengwei
 * @since 2021/6/24
 */
public class ServerException extends TemplatedRuntimeException {
    public ServerException() {
    }

    public ServerException(String message, Object... args) {
        super(message, args);
    }

    public ServerException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }

    public ServerException(Throwable cause) {
        super(cause);
    }

    public ServerException(Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message, Object... args) {
        super(cause, enableSuppression, writableStackTrace, message, args);
    }
}