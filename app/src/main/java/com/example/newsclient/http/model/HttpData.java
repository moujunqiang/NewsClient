package com.example.newsclient.http.model;

/**
 * desc   : 统一接口数据结构
 */
public class HttpData<T> {

    /**
     * 返回码
     */
    private int code;
    /**
     * 提示语
     */
    private String msg;
    /**
     * 数据
     */
    private T newslist;

    public int getResultStatus() {
        return code;
    }

    public String getMessage() {
        return msg;
    }

    public T getData() {
        return newslist;
    }
}