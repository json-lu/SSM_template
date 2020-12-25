package com.ljx.exercise.enums;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 17:27 2020/12/21
 * @Author: Ljx
 * @Decription:
 */
public enum MsgNum implements ExceptionEnum{

    SUCCESS(200,"请求成功!"),
    ERROR(500,"服务器错误，请联系管理员!"),
    FROM_NO_TYPE(409,"表单不支持文件上传!"),
    DOWNLOAD_ERROR(410,"下载失败!");


    private int code;
    private String msg;

    MsgNum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
