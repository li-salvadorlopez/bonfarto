package com.azteklabs.doctorservice.infrastructure.adapter.repository;

import com.azteklabs.doctorservice.BaseIT;
import com.azteklabs.doctorservice.domain.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class JpaDoctorsRepositoryImplIT extends BaseIT {


    @Autowired
    private DoctorsRepository doctorsRepository;

    @Test
    void saveDoctor() {
        DoctorIdentifier doctorIdentifier = new DoctorIdentifier(UUID.randomUUID().toString());
        Doctor doctor = new Doctor(doctorIdentifier, new Name("Diego Armando", "Maradona"));
        doctor.addAddress(new Address(new AddressIdentifier(UUID.randomUUID().toString()), "Benecia St", "Lops Angeles", "California", "90210", "USA"));
        var addedDoctor = doctorsRepository.saveDoctor(doctor);
        assertThat(addedDoctor).isNotNull();
        assertThat(addedDoctor.getDoctorIdentifier()).isEqualTo(doctorIdentifier);
        assertThat(addedDoctor.getAddresses().size()).isEqualTo(1);
    }

}