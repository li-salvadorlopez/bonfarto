package com.azteklabs.doctorservice.infrastructure.adapter.repository;

import com.azteklabs.doctorservice.domain.model.*;
import com.azteklabs.doctorservice.infrastructure.adapter.repository.entity.DoctorEntity;
import com.azteklabs.doctorservice.infrastructure.adapter.repository.entity.DoctorMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        Pageable pageable = org.springframework.data.domain.PageRequest.of(pageRequest.getPage(), pageRequest.getSize());
        org.springframework.data.domain.Page<DoctorEntity> doctorEntityPage = springDataDoctorsRepository.findAll(pageable);
        List<Doctor> doctorList = DoctorMapper.INSTANCE.getDoctorsFromEntities(doctorEntityPage.stream().toList());
        // TODO Add the total elements to the returned page
        return  new Page<>(doctorList, pageRequest.getPage(), pageRequest.getSize(), 0);
    }

    @Override
    public void deleteDoctor(DoctorIdentifier doctorIdentifier) {
        throw new RuntimeException("NOT IMPLEMENTEED");
    }
}
