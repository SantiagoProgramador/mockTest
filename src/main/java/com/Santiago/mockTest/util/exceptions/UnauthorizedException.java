package com.Santiago.mockTest.util.exceptions;


public class UnauthorizedException extends RuntimeException {
    private static final String errorMessage = "The user is unauthorized";
    public UnauthorizedException() {
        super(errorMessage);
    }
}