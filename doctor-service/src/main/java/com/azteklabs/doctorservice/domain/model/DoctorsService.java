package com.azteklabs.doctorservice.domain.model;

public interface DoctorsService {

    Doctor retrieveDoctor(DoctorIdentifier doctorIdentifier);
    Page<Doctor> retrieveDoctors(PageRequest pageRequest);
    Doctor createDoctorProfile(Doctor doctor);
    void deleteDoctorProfile(DoctorIdentifier doctorIdentifier);
    Doctor updateDoctorProfileInfo(Doctor doctor);

}
