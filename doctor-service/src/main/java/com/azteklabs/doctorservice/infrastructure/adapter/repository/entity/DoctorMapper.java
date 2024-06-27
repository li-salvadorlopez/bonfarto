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

    @Mapping(source = "doctorIdentifier.id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "addresses", target = "addresses")
    DoctorEntity domainToEntity(Doctor doctor);

    @Mapping(source = "id", target = "doctorIdentifier.id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "addresses", target = "addresses")
    Doctor entityToDomain(DoctorEntity doctorEntity);

    @Mapping(source = "addressIdentifier.id", target = "id")
    AddressEntity addressToAddressEntity(Address address);

    @Mapping(source = "id", target = "addressIdentifier.id")
    Address addressEntityToAddress(AddressEntity addressEntity);

    NameEmbeddable nameToNameEmbeddable(Name name);

    Name nameEmbeddableToName(NameEmbeddable nameEmbeddable);
}
