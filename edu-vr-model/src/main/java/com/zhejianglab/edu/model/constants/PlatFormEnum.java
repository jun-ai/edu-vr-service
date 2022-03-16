package com.zhejianglab.edu.model.constants;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public enum PlatFormEnum {

    FILE_FORMAT_ERROR(10001,"文件格式错误"),
    UPDATE_FAIL(10002,"更新失败"),
    INSERT_FAIL(10003,"插入失败"),
    INSERT_REPEAT(10005,"重复插入"),
    DOWNLOAD_FAIL(10004,"导出失败"),
    CREATE_ROOM_FAIL(10006,"创建房间失败"),
    LEFT_ROOM_FAIL(10007,"离开房间失败"),
    PARAMETER_EMPTY(10008,"参数为空"),
    AUTH_FAIL(10009,"教师赋权失败"),
    INSERT_ROOM_FAIL(10010,"加入房间失败"),
    SUCCESS(200,"操作成功"),
    FAIL(500,"操作失败");
    @Getter
    @Setter
    public final Integer code;
    @Getter
    @Setter
    public final String name;

    PlatFormEnum(int code, String name) {
        this.name = name;
        this.code = code;
    }


    public static String getValue(Integer value) {
        PlatFormEnum[] docTypeDicts = values();
        for (PlatFormEnum docTypeDict : docTypeDicts) {
            if (docTypeDict.code.equals(value)) {
                return docTypeDict.name;
            }
        }
        return null;
    }

    public static Integer getCode(String name) {
        PlatFormEnum[] docTypeDicts = values();
        for (PlatFormEnum docTypeDict : docTypeDicts) {
            if (docTypeDict.name().equals(name)) {
                return docTypeDict.code;
            }
        }
        return -1;
    }
}
