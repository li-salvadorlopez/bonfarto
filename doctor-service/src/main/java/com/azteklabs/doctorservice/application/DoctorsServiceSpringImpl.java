package com.azteklabs.doctorservice.application;

import com.azteklabs.doctorservice.domain.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsServiceSpringImpl implements DoctorsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorsServiceSpringImpl.class);

    private final DoctorsRepository doctorsRepository;

    public DoctorsServiceSpringImpl(DoctorsRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
    }

    @Override
    public Doctor retrieveDoctor(DoctorIdentifier doctorIdentifier) {
        return doctorsRepository.findByIdentifier(doctorIdentifier);
    }

    @Override
    public Page<Doctor> retrieveDoctors(PageRequest pageRequest) {
        return doctorsRepository.findAllDoctors(pageRequest);
    }

    @Override
    public List<Doctor> retrieveAllDoctors() {
        return doctorsRepository.findAllDoctors();
    }

    @Override
    public Doctor createDoctorProfile(Doctor doctor) {
        return doctorsRepository.saveDoctor(doctor);
    }

    @Override
    public void deleteDoctorProfile(DoctorIdentifier doctorIdentifier) {
        doctorsRepository.deleteDoctor(doctorIdentifier);
    }

    @Override
    public Doctor updateDoctorProfileInfo(Doctor doctor) {
        return null;
    }
}
