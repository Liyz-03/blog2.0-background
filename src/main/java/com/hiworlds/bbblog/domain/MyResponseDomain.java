package com.hiworlds.bbblog.domain;

public class MyResponseDomain<T> {
    private String code;
    private String msg;
    private T Data;

    public MyResponseDomain() {
    }

    public MyResponseDomain(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        Data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "MyResponseDomain{" + "code='" + code + '\'' + ", msg='" + msg + '\'' + ", Data=" + Data + '}';
    }
}
