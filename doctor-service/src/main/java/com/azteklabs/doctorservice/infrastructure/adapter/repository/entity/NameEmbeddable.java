package com.azteklabs.doctorservice.infrastructure.adapter.repository.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class NameEmbeddable {

    private String firstname;
    private String lastname;

    public NameEmbeddable() {
    }

    public NameEmbeddable(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Getters and setters

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }
}
