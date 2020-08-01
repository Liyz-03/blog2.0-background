package com.hiworlds.bbblog.exceptionHandler;

import com.hiworlds.bbblog.domain.MyResponseDomain;
import com.hiworlds.bbblog.myException.MyExceptionResult;
import com.hiworlds.bbblog.myException.errorMsgConstant.ResponseMsgConstant;
import com.hiworlds.bbblog.myException.myExceptions.LoginFailedException;
import com.hiworlds.bbblog.myException.myExceptions.RequestParamsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 处理登录失败
     * @param e
     * @return
     */
    @ExceptionHandler(LoginFailedException.class)
    @ResponseBody
    public MyResponseDomain handler(LoginFailedException e){
        return new MyExceptionResult<>().failed(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public MyResponseDomain handler(Exception e){
        return new MyExceptionResult<>().failed(e.getMessage());
    }

    @ExceptionHandler(RequestParamsException.class)
    @ResponseBody
    public MyResponseDomain handler(RequestParamsException e){
        return new MyExceptionResult<>().failed(ResponseMsgConstant.ERROR_MSG_PARAMS_EXCPTION);
    }
}
