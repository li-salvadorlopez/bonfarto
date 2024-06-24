package com.azteklabs.doctorservice.infrastructure.adapter.repository;

import com.azteklabs.doctorservice.BaseIT;
import com.azteklabs.doctorservice.domain.model.Doctor;
import com.azteklabs.doctorservice.domain.model.DoctorIdentifier;
import com.azteklabs.doctorservice.domain.model.DoctorsRepository;
import com.azteklabs.doctorservice.domain.model.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JpaDoctorsRepositoryImplIT extends BaseIT {


    @Autowired
    private DoctorsRepository doctorsRepository;

    @Test
    void saveDoctor() {
        Doctor doctor = new Doctor(
                new DoctorIdentifier("xyz"),
                new Name("x", "y"),
                List.of()
        );
        var addedDoctor = doctorsRepository.saveDoctor(doctor);
        assertThat(addedDoctor).isNotNull();
        assertThat(addedDoctor.getDoctorIdentifier()).isEqualTo(new DoctorIdentifier("xyz"));
    }

}