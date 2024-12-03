package com.tecnosmart.utils;

public class AppException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public AppException(String message) {
        super(message);
    }
    
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}