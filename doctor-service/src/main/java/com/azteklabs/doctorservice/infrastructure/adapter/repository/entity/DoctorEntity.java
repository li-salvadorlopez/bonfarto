package com.azteklabs.doctorservice.infrastructure.adapter.repository.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "doctors")
public class DoctorEntity {
    @Id
    private String doctorId;
    @Embedded
    private NameEmbeddable name;
    @OneToMany
    private List<AddressEntity> addresses;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Instant createdDate;
    @LastModifiedBy
    private String lastModifiedBy;
    @LastModifiedDate
    private Instant lastModifiedDate;


    public DoctorEntity() {
    }

    public DoctorEntity(String doctorId, NameEmbeddable name) {
        this.doctorId = doctorId;
        this.name = name;
    }

    // Getters and setters

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public NameEmbeddable getName() {
        return name;
    }

    public void setName(NameEmbeddable name) {
        this.name = name;
    }

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String user) {
        this.createdBy = user;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
