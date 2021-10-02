package com.rmslab.demsystem.controllers;

import com.rmslab.demsystem.exception.ResourceAlreadyExistException;
import com.rmslab.demsystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @Value(value = "${data.exception.message1}")
    private String message1 ;
    @Value(value = "${data.exception.message2}")
    private String message2 ;
    @Value(value = "${data.exception.message3}")
    private String message3 ;

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ResourceAlreadyExistException.class)
    public ResponseEntity resourceAlreadyExistsExceptionHandler(ResourceAlreadyExistException resourceAlreadyExistException) {
        return new ResponseEntity(message1, HttpStatus.CONFLICT) ;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException) {
        return new ResponseEntity(message2, HttpStatus.NOT_FOUND) ;
    }
}
