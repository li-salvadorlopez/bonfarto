package com.azteklabs.doctorservice.domain.model;

public class DoctorNotFoundException extends RuntimeException{

    public DoctorNotFoundException(String message) {
        super(message);
    }

    public DoctorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
