package com.together.date.result;

import lombok.Data;

@Data
public class result {
    public boolean flag;

    private String message;
    private Object data;

    public result(boolean flag, String message){
        this.flag = flag;
        this.message = message;
    }

    /**
     * 返回结果的信息
     * @param flag    返回是否成功
     * @param message 返回的信息
     * @param data    返回结果
     */
    public result (boolean flag, String message, Object data){
        this.flag = flag;
        this.message = message;
        this.data = data;
    }


    public static result success(String message,Object data){
        return new result(true,message,data);
    }
    public static result success(String message) {
        return new result(true, message);
    }


    public static result fail(String message, Object data){
        return new result(false,message,data);
    }

    public static result fail (String message){
        return new result(false,message);
    }
}
