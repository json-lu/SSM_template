package com.ljx.exercise.helper;

import com.ljx.exercise.enums.MsgNum;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 17:34 2020/12/21
 * @Author: Ljx
 * @Decription:
 */
public class Result{

    private int code;//状态码
    private String msg;//消息
    private Object data;//返回数据

    public Result(int code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Result(int code,Object data){
        this.code = code;
        this.data = data;
    }

    public Result(){

    }

    public static Result SUCCESS(){
        return new Result(MsgNum.SUCCESS.getCode(),MsgNum.SUCCESS.getMessage());
    }

    public static Result SUCCESS(Object data){
        return new Result(MsgNum.SUCCESS.getCode(),MsgNum.SUCCESS.getMessage(),data);
    }
    public static Result SUCCESS(String text){
        return new Result(MsgNum.SUCCESS.getCode(),MsgNum.SUCCESS.getMessage()+":"+text);
    }

    public static Result SUCCESS(String text,Object data){
        return new Result(MsgNum.SUCCESS.getCode(),MsgNum.SUCCESS.getMessage()+":"+text,data);
    }


    public static Result ERROR(){
        return new Result(MsgNum.ERROR.getCode(),MsgNum.ERROR.getMessage());
    }

    public static Result ERROR(Object data){
        return new Result(MsgNum.ERROR.getCode(),MsgNum.ERROR.getMessage(),data);
    }
    public static Result ERROR(String text){
        return new Result(MsgNum.ERROR.getCode(),MsgNum.ERROR.getMessage()+":"+text);
    }

    public static Result ERROR(String text,Object data){
        return new Result(MsgNum.ERROR.getCode(),MsgNum.ERROR.getMessage()+":"+text,data);
    }

    public static Result FROM_NO_TYPE(){
        return new Result(MsgNum.FROM_NO_TYPE.getCode(),MsgNum.FROM_NO_TYPE.getMessage());
    }

    public static Result FROM_NO_TYPE(Object data){
        return new Result(MsgNum.FROM_NO_TYPE.getCode(),MsgNum.FROM_NO_TYPE.getMessage(),data);
    }
    public static Result FROM_NO_TYPE(String text){
        return new Result(MsgNum.FROM_NO_TYPE.getCode(),MsgNum.FROM_NO_TYPE.getMessage()+":"+text);
    }

    public static Result FROM_NO_TYPE(String text,Object data){
        return new Result(MsgNum.FROM_NO_TYPE.getCode(),MsgNum.FROM_NO_TYPE.getMessage()+":"+text,data);
    }

}
