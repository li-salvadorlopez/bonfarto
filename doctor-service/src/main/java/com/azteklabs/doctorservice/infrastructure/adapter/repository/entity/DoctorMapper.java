package com.azteklabs.doctorservice.infrastructure.adapter.repository.entity;

import com.azteklabs.doctorservice.domain.model.Address;
import com.azteklabs.doctorservice.domain.model.Doctor;
import com.azteklabs.doctorservice.domain.model.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Mapping(source = "doctorIdentifier.id", target = "doctorId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "addresses", target = "addresses")
    DoctorEntity domainToEntity(Doctor doctor);

    @Mapping(source = "doctorId", target = "doctorIdentifier.id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "addresses", target = "addresses")
    Doctor entityToDomain(DoctorEntity doctorEntity);

    AddressEntity addressToAddressEntity(Address address);

    Address addressEntityToAddress(AddressEntity addressEntity);

    NameEmbeddable nameToNameEmbeddable(Name name);

    Name nameEmbeddableToName(NameEmbeddable nameEmbeddable);
}
