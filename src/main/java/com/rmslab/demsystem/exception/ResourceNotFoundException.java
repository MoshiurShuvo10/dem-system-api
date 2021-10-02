package com.rmslab.demsystem.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String message ;

    public ResourceNotFoundException(String message) {
        this.message = message;
    }

    public ResourceNotFoundException() {
    }
}
