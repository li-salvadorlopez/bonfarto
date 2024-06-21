package com.azteklabs.doctorservice.infrastructure.adapter.repository.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class NameEmbeddable {

    private String firstName;
    private String lastName;

    public NameEmbeddable() {
    }

    public NameEmbeddable(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
