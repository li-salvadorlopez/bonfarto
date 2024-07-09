package com.azteklabs.doctorservice.domain.model;

import java.util.List;

public interface DoctorsService {

    Doctor retrieveDoctor(DoctorIdentifier doctorIdentifier);

    Page<Doctor> retrieveDoctors(PageRequest pageRequest);

    List<Doctor> retrieveAllDoctors();

    Doctor createDoctorProfile(Doctor doctor);

    void deleteDoctorProfile(DoctorIdentifier doctorIdentifier);

    Doctor updateDoctorProfileInfo(Doctor doctor);

}
