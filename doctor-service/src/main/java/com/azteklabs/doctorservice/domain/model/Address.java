package com.azteklabs.doctorservice.domain.model;

public class Address {
    private final AddressIdentifier addressIdentifier;
    private final String street;
    private final String city;
    private final String state;
    private final String zipcode;
    private final String country;

    public Address(AddressIdentifier addressIdentifier, String street, String city, String state, String zipcode, String country) {
        this.addressIdentifier = addressIdentifier;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }

    public AddressIdentifier getAddressIdentifier() {
        return addressIdentifier;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCountry() {
        return country;
    }
}
