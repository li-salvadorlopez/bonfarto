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
        return DoctorMapper.INSTANCE.entityToDomain(springDataDoctorsRepository.save(doctorEntity));
    }

    @Override
    public Doctor findByIdentifier(DoctorIdentifier doctorIdentifier) {
        DoctorEntity doctorEntity = springDataDoctorsRepository.findById(doctorIdentifier.id()).orElseThrow(
                () -> new DoctorNotFoundException(STR."Doctor with id \{doctorIdentifier.id()} was not found")
        );
        return DoctorMapper.INSTANCE.entityToDomain(doctorEntity);
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
