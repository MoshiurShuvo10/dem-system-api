package com.rmslab.demsystem.exception;

public class ResourceAlreadyExistException extends RuntimeException{
    private String message ;

    public ResourceAlreadyExistException(String message) {
        this.message = message;
    }

    public ResourceAlreadyExistException() {
    }
}
