package com.hiworlds.bbblog.myException;

import com.hiworlds.bbblog.domain.MyResponseDomain;

public class MyExceptionResult<T> {
    /**
     * 成功有数据和无数据
     */
    public MyResponseDomain success(String message) {

        return new MyResponseDomain("200",message,null);
    }
    public MyResponseDomain<T> successWithData(String message, T data) {
        return new MyResponseDomain("200",message,data);
    }
    /**
     * 失败有数据和无数据
     */
    public MyResponseDomain failed(String message) {
        return new MyResponseDomain("400",message,null);
    }
    public MyResponseDomain<T> failedWithData(String message, T data) {
        return new MyResponseDomain("400",message,data);
    }
}
