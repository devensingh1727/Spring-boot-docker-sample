package com.deven.dockerApplication.exception;

import com.deven.dockerApplication.constant.AppConstant;
import com.deven.dockerApplication.model.request.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import static com.deven.dockerApplication.constant.AppConstant.ApiHeader.CORRELATION_ID;
import static com.deven.dockerApplication.constant.AppConstant.ErrorCode.ERR_500;
import static com.deven.dockerApplication.constant.AppConstant.ErrorMessage.GENERIC_ERROR_MESSAGE;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<BaseResponse> handleException(Exception exception, WebRequest webRequest) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(ERR_500);
        baseResponse.setMessage(StringUtils.hasText(exception.getMessage()) ? exception.getMessage() : GENERIC_ERROR_MESSAGE);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(CORRELATION_ID, webRequest.getHeader(CORRELATION_ID));
        return new ResponseEntity<>(baseResponse, httpHeaders, HttpStatus.OK);
    }

    @ExceptionHandler({AppException.class})
    public ResponseEntity<BaseResponse> handleAppException(AppException exception, WebRequest webRequest) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(exception.getCode());
        baseResponse.setMessage(exception.getMessage());
        baseResponse.setErrorData(exception.getErrorObject());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(CORRELATION_ID, webRequest.getHeader(CORRELATION_ID));
        return new ResponseEntity<>(baseResponse, httpHeaders, HttpStatus.OK);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<BaseResponse> handleBadRequestException(BadRequestException exception, WebRequest webRequest) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(exception.getCode());
        baseResponse.setMessage(exception.getMessage());
        baseResponse.setErrorData(exception.getErrorObject());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(CORRELATION_ID, webRequest.getHeader(CORRELATION_ID));
        return new ResponseEntity<>(baseResponse, httpHeaders, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, MissingServletRequestParameterException.class})
    public ResponseEntity<BaseResponse> handleMethodArgumentNotValidException(Exception exception, WebRequest webRequest) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(AppConstant.ErrorCode.ERR_400);
        baseResponse.setMessage(exception.getMessage());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(CORRELATION_ID, webRequest.getHeader(CORRELATION_ID));
        return new ResponseEntity<>(baseResponse, httpHeaders, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<BaseResponse> handleNoHandlerFoundException(NoHandlerFoundException exception, WebRequest webRequest) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(AppConstant.ErrorCode.ERR_404);
        baseResponse.setMessage(exception.getMessage());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(CORRELATION_ID, webRequest.getHeader(CORRELATION_ID));
        return new ResponseEntity<>(baseResponse, httpHeaders, HttpStatus.NOT_FOUND);
    }

}
