package com.zhejianglab.edu.model.base;


import com.zhejianglab.edu.model.constants.PlatFormEnum;

import java.util.HashMap;

public class AjaxResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 Message 对象
     */
    public AjaxResult()
    {
    }
    /**
     * 返回错误消息
     *
     * @param code 错误码
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResult error(int code, String msg, DataResult data)
    {
        AjaxResult json = new AjaxResult();
        json.put("code", code);
        json.put("msg", msg);
        json.put("data", data);
        return json;
    }
    /**
     * 返回成功消息
     * @param data 数量
     * @return 成功消息
     */
    public static AjaxResult success(DataResult data)
    {
        AjaxResult json = new AjaxResult();
        json.put("code", PlatFormEnum.SUCCESS.getCode());
        json.put("msg", PlatFormEnum.SUCCESS.getName());
        json.put("data", data);
        return json;
    }

    public static AjaxResult success()
    {
        AjaxResult json = new AjaxResult();
        json.put("code", PlatFormEnum.SUCCESS.getCode());
        json.put("msg", PlatFormEnum.SUCCESS.getName());
        json.put("data", "");
        return json;
    }
    /**
     * 返回成功消息
     *
     * @param key 键值
     * @param value 内容
     * @return 成功消息
     */
    @Override
    public AjaxResult put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }

}
