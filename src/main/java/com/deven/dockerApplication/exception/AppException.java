package com.deven.dockerApplication.exception;

import lombok.Data;

import static com.deven.dockerApplication.constant.AppConstant.ErrorCode.ERR_500;


@Data
public class AppException extends RuntimeException{

    private String code;
    private String message;
    private Throwable throwable;
    private Object errorObject;
    Boolean isRetryable;

    public AppException(String code, String message, Throwable throwable, Object errorObject, Boolean isRetryable){
        this.code = code;
        this.message = message;
        this.throwable = throwable;
        this.errorObject = errorObject;
        this.isRetryable = isRetryable;
    }

    public AppException(String code, String message){
        this(code, message, null, null, false);
    }

    public AppException(String message){
        this(ERR_500, message);
    }
}
