package com.azteklabs.doctorservice.infrastructure.adapter.repository;

import com.azteklabs.doctorservice.domain.model.*;
import com.azteklabs.doctorservice.infrastructure.adapter.repository.entity.DoctorEntity;
import com.azteklabs.doctorservice.infrastructure.adapter.mapper.DoctorMapper;
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
        return springDataDoctorsRepository.findById(doctorIdentifier.id())
                .map(DoctorMapper.INSTANCE::entityToDomain)
                .orElseThrow(
                        () -> new DoctorNotFoundException(new StringBuilder("Doctor with id").append(doctorIdentifier.id()).append("was not found").toString())
                );
    }

    @Override
    public Page<Doctor> findAllDoctors(PageRequest pageRequest) {
        Pageable pageable = org.springframework.data.domain.PageRequest.of(pageRequest.getPage(), pageRequest.getSize());
        List<DoctorEntity> doctorEntities = springDataDoctorsRepository.findAll(pageable)
                .stream()
                .toList();
        List<Doctor> doctorList = DoctorMapper.INSTANCE.getDoctorsFromEntities(doctorEntities);
        // TODO Add the total elements to the returned page
        return new Page<>(doctorList, pageRequest.getPage(), pageRequest.getSize(), 0);
    }

    @Override
    public List<Doctor> findAllDoctors() {
        List<DoctorEntity> doctorEntities = springDataDoctorsRepository.findAll();
        return DoctorMapper.INSTANCE.getDoctorsFromEntities(doctorEntities);
    }

    @Override
    public void deleteDoctor(DoctorIdentifier doctorIdentifier) {
        springDataDoctorsRepository.deleteById(doctorIdentifier.id());
    }
}
