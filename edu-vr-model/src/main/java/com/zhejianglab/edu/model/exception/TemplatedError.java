package com.zhejianglab.edu.model.exception;

import cn.hutool.core.util.StrUtil;

/**
 * 支持模板功能的Error基类
 *
 * @author chengwei
 * @since 2021/6/24
 */
public abstract class TemplatedError extends Error {

    /**
     * 提供一个空参构造器
     */
    public TemplatedError() {
        super();
    }

    /**
     * 提供一个带有消息模板功能的构造器
     *
     * @param message 消息模板，使用{}占位
     * @param args    参数
     */
    public TemplatedError(String message, Object... args) {
        super(message == null ? null : StrUtil.format(message, args));
    }

    /**
     * 提供一个带有消息模板功能和缘由异常的构造器
     *
     * @param cause   触发此异常的缘由异常
     * @param message 消息模板，使用{}占位
     * @param args    参数
     */
    public TemplatedError(Throwable cause, String message, Object... args) {
        super(message == null ? null : StrUtil.format(message, args), cause);
    }

    /**
     * 提供一个带有缘由异常的构造器
     *
     * @param cause 触发此异常的缘由异常
     */
    public TemplatedError(Throwable cause) {
        super(cause);
    }

    /**
     * 提供一个异常对象的全参构造器
     *
     * @param message 消息模板，使用{}占位
     * @param cause   触发此异常的缘由异常
     * @param args    参数
     */
    public TemplatedError(Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message, Object... args) {
        super(message == null ? null : StrUtil.format(message, args), cause, enableSuppression, writableStackTrace);
    }
}
