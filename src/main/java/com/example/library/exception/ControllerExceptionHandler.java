package com.example.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ErrorMessage objectNotFoundException(ObjectNotFoundException exception, WebRequest webRequest) {
        return new ErrorMessage(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), exception.getMessage(),
                webRequest.getDescription(false));
    }

    @ExceptionHandler(Exception.class)
    public ErrorMessage objectNotFoundException(Exception exception, WebRequest webRequest) {
        return new ErrorMessage(System.currentTimeMillis(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(), webRequest.getDescription(false));
    }

}
