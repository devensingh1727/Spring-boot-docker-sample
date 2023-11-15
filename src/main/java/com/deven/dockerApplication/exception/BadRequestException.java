package com.deven.dockerApplication.exception;

public class BadRequestException extends AppException{
    public BadRequestException(String code, String message) {
        super(code, message);
    }
}
