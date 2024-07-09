package com.azteklabs.doctorservice.domain.model;

import java.util.List;

public interface DoctorsRepository {
    Doctor saveDoctor(Doctor doctor);

    Doctor findByIdentifier(DoctorIdentifier doctorIdentifier);

    Page<Doctor> findAllDoctors(PageRequest pageRequest);

    List<Doctor> findAllDoctors();

    void deleteDoctor(DoctorIdentifier doctorIdentifier);
}
