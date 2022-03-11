package com.zhejianglab.edu.model.base;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

@Getter
@Setter
@Data
public class DataResult extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 Message 对象
     */
    public DataResult()
    {

    }

    public static DataResult success()
    {
        DataResult json = new DataResult();
        //json.put("data", "");
        return json;
    }
    /**
     * 返回成功消息
     * @param data 数据
     * @return 成功消息
     */
    public static DataResult success(Object data)
    {
        DataResult json = new DataResult();
        json.put("data", data);
        return json;
    }

    public static DataResult success(Object data,int total)
    {
        DataResult json = new DataResult();
        json.put("total", total);
        json.put("data", data);
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
    public DataResult put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }

}
