package com.azteklabs.doctorservice.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Doctor {

    private DoctorIdentifier doctorIdentifier;
    private Name name;
    private List<Address> addresses = new ArrayList<>();
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public Doctor() {
    }

    public Doctor(DoctorIdentifier doctorIdentifier, Name name) {
        this.doctorIdentifier = doctorIdentifier;
        this.name = name;
    }

    public Doctor(DoctorIdentifier doctorIdentifier, Name name, List<Address> addresses) {
        if (doctorIdentifier == null){
            throw new IllegalArgumentException("Doctor identifier cannot be null");
        }
        this.doctorIdentifier = doctorIdentifier;
        this.name = name;
        this.addresses = addresses;
    }

    public DoctorIdentifier getDoctorIdentifier() {
        return doctorIdentifier;
    }

    public void setDoctorIdentifier(DoctorIdentifier doctorIdentifier) {
        this.doctorIdentifier = doctorIdentifier;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address){
        this.addresses.add(address);
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorIdentifier=" + doctorIdentifier +
                ", name=" + name +
                ", addresses=" + addresses +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
