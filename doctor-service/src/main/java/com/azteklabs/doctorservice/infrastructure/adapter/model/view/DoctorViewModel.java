package com.azteklabs.doctorservice.infrastructure.adapter.model.view;

import java.util.List;

public record DoctorViewModel(
        String id,
        String firstname,
        String lastname,
        List<AddressViewModel> addresses,
        List<String> phoneNumbers) {
}
