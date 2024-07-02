package com.azteklabs.doctorservice.domain.model;

import java.util.Objects;

/**
 * Pacient name Value Object, this class is meant to be immutable and should handle the validation logic for a patient's name
 */
public class Name{
    private final String firstname;
    private final String lastname;

    public Name(String firstname, String lastname) {
        if (firstname == null || firstname.isEmpty() || firstname.isBlank()){
            throw new IllegalArgumentException("Firstname is required");
        }
        if (lastname == null || lastname.isEmpty() || firstname.isBlank()){
            throw new IllegalArgumentException("Lastname is required");
        }
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstname, name.firstname) && Objects.equals(lastname, name.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                '}';
    }
}
