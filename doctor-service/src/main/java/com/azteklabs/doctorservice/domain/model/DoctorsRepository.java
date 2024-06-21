package com.azteklabs.doctorservice.domain.model;

public interface DoctorsRepository {
    Doctor saveDoctor(Doctor doctor);
    Doctor findByIdentifier(DoctorIdentifier doctorIdentifier);
    Page<Doctor> findAllDoctors(PageRequest pageRequest);
    void deleteDoctor(DoctorIdentifier doctorIdentifier);
}
