package com.azteklabs.doctorservice.infrastructure.adapter.repository;

import com.azteklabs.doctorservice.BaseIT;
import com.azteklabs.doctorservice.domain.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void findExistentDoctor() {
        DoctorIdentifier doctorIdentifier = new DoctorIdentifier("e2f5b1e0-f38e-4a60-9f39-1e6144e2a1be");
        var foundDoctor = doctorsRepository.findByIdentifier(doctorIdentifier);
        assertThat(foundDoctor).isNotNull();
        assertThat(foundDoctor.getDoctorIdentifier()).isEqualTo(doctorIdentifier);
        assertThat(foundDoctor.getName().getFirstname()).isEqualTo("John");
    }

    @Test
    void findNonExistentDoctor() {
        DoctorNotFoundException exception = assertThrows(DoctorNotFoundException.class, () -> {
            DoctorIdentifier doctorIdentifier = new DoctorIdentifier("invalid");
            doctorsRepository.findByIdentifier(doctorIdentifier);
        });
        assertThat(exception.getMessage()).isEqualTo("Doctor with id invalid was not found");
    }

    @Test
    void findAllDoctors() {
        List<Doctor> doctorList = doctorsRepository.findAllDoctors(new PageRequest(0, 2)).getContent();
        assertThat(doctorList).size().isEqualTo(2);
        assertThat(doctorList.get(0).getName().getFirstname()).isEqualTo("John");
    }

    @Test
    void findAllDoctorsUnreachablePage() {
        List<Doctor> doctorList = doctorsRepository.findAllDoctors(new PageRequest(10, 2)).getContent();
        assertThat(doctorList).isEmpty();
    }

}