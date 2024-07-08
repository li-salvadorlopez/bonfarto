package com.azteklabs.doctorservice.application;

import com.azteklabs.doctorservice.BaseIT;
import com.azteklabs.doctorservice.domain.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DoctorsServiceSpringIT extends BaseIT {

    @Autowired
    private DoctorsService doctorsService;


    @Test
    void retrieveDoctor() {
        Doctor doctor = doctorsService.retrieveDoctor(new DoctorIdentifier("6e7a1d6e-2f5b-4e6f-9e3e-2b9a5e8f7e1d"));
        assertThat(doctor).isNotNull();
        assertThat(doctor.getDoctorIdentifier().id()).isEqualTo("6e7a1d6e-2f5b-4e6f-9e3e-2b9a5e8f7e1d");
        assertThat(doctor.getName().getFirstname()).isEqualTo("Robert");
    }

    @Test
    void retrieveDoctors() {
        Page<Doctor> doctorPage = doctorsService.retrieveDoctors(new PageRequest(0, 2));
        assertThat(doctorPage).isNotNull();
        assertThat(doctorPage.getContent()).isNotNull();
        assertThat(doctorPage.getContent().size()).isEqualTo(2);
    }

    @Test
    void createDoctorProfile() {
        DoctorIdentifier doctorIdentifier = new DoctorIdentifier(UUID.randomUUID().toString());
        Doctor doctor = new Doctor(doctorIdentifier, new Name("Louis", "Kerry"));
        doctor.addAddress(new Address(new AddressIdentifier(UUID.randomUUID().toString()), "1273 x road", "Dallas", "Texas", "30210", "USA"));
        var addedDoctor = doctorsService.createDoctorProfile(doctor);
        assertThat(addedDoctor).isNotNull();
        assertThat(addedDoctor.getDoctorIdentifier()).isEqualTo(doctorIdentifier);
        assertThat(addedDoctor.getAddresses().size()).isEqualTo(1);
    }

    @Test
    void deleteDoctorProfile() {
        DoctorIdentifier doctorIdentifier = new DoctorIdentifier("1b9a9f1e-2b7f-4e6b-9f1e-2d6e7f8e5a9c");
        doctorsService.deleteDoctorProfile(doctorIdentifier);
        DoctorNotFoundException doctorNotFoundException = assertThrows(DoctorNotFoundException.class, () -> {
            doctorsService.retrieveDoctor(doctorIdentifier);
        });
        assertThat(doctorNotFoundException.getMessage()).isEqualTo("Doctor with id 1b9a9f1e-2b7f-4e6b-9f1e-2d6e7f8e5a9c was not found");
    }

}