package com.azteklabs.doctorservice.infrastructure.adapter.model.view;

public record AddressViewModel(
        String street,
        String city,
        String state,
        String zipcode,
        String country) {
}
