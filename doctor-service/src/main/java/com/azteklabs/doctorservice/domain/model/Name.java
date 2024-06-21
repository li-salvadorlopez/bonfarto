package com.azteklabs.doctorservice.domain.model;

import java.util.Objects;

/**
 * Pacient name Value Object, this class is meant to be immutable and should handle the validation logic for a patient's name
 */
public class Name{
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        if (firstName == null || firstName.isEmpty() || firstName.isBlank()){
            throw new IllegalArgumentException("Firstname is required");
        }
        if (lastName == null || lastName.isEmpty() || firstName.isBlank()){
            throw new IllegalArgumentException("Lastname is required");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
