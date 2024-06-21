package com.azteklabs.doctorservice.domain.model;

public record DoctorIdentifier(String id) {

    public DoctorIdentifier {
        if (id == null || id.isEmpty() || id.isBlank()) {
            throw new IllegalArgumentException("Id cannot be null or empty");
        }
    }
}
