package com.azteklabs.doctorservice.infrastructure.adapter.repository;

import com.azteklabs.doctorservice.domain.model.*;
import com.azteklabs.doctorservice.infrastructure.adapter.repository.entity.DoctorEntity;
import com.azteklabs.doctorservice.infrastructure.adapter.repository.entity.DoctorMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JpaDoctorsRepositoryImpl implements DoctorsRepository {

    private final SpringDataDoctorsRepositoryImpl springDataDoctorsRepository;

    public JpaDoctorsRepositoryImpl(SpringDataDoctorsRepositoryImpl springDataDoctorsRepository) {
        this.springDataDoctorsRepository = springDataDoctorsRepository;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        DoctorEntity doctorEntity = DoctorMapper.INSTANCE.domainToEntity(doctor);
        Doctor addedDoctor = DoctorMapper.INSTANCE.entityToDomain(springDataDoctorsRepository.save(doctorEntity));
        return addedDoctor;
    }

    @Override
    public Doctor findByIdentifier(DoctorIdentifier doctorIdentifier) {
        throw new RuntimeException("NOT IMPLEMENTEED");
    }

    @Override
    public Page<Doctor> findAllDoctors(PageRequest pageRequest) {
        throw new RuntimeException("NOT IMPLEMENTEED");
    }

    @Override
    public void deleteDoctor(DoctorIdentifier doctorIdentifier) {
        throw new RuntimeException("NOT IMPLEMENTEED");
    }
}
