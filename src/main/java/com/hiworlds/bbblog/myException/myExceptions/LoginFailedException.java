package com.hiworlds.bbblog.myException.myExceptions;

/**
 * 登录异常
 */
public class LoginFailedException extends RuntimeException {
    static final long serialVersionUID = 1L;

    public LoginFailedException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public LoginFailedException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public LoginFailedException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
