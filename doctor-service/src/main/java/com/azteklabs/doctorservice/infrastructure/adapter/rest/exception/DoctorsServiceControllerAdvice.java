package com.azteklabs.doctorservice.infrastructure.adapter.rest.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class DoctorsServiceControllerAdvice {


    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e){
        List<String> violations =  e.getConstraintViolations().stream()
                .map(constraintViolation -> constraintViolation.getMessage() )
                .collect(Collectors.toList());
        return new ResponseEntity<>(violations, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
