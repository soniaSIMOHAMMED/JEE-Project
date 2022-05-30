package com.springboot.application.kernel.exception;

import org.springframework.http.HttpStatus;

public class RestAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public RestAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public RestAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
