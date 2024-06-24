package com.azteklabs.doctorservice.infrastructure.adapter.repository;

import com.azteklabs.doctorservice.infrastructure.adapter.repository.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataDoctorsRepositoryImpl extends JpaRepository<DoctorEntity, String> {

}
