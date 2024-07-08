package com.azteklabs.doctorservice.infrastructure.adapter.mapper;

import com.azteklabs.doctorservice.domain.model.Address;
import com.azteklabs.doctorservice.domain.model.Doctor;
import com.azteklabs.doctorservice.domain.model.Name;
import com.azteklabs.doctorservice.domain.model.PhoneNumber;
import com.azteklabs.doctorservice.infrastructure.adapter.model.view.AddressViewModel;
import com.azteklabs.doctorservice.infrastructure.adapter.model.view.DoctorViewModel;
import com.azteklabs.doctorservice.infrastructure.adapter.repository.entity.AddressEntity;
import com.azteklabs.doctorservice.infrastructure.adapter.repository.entity.DoctorEntity;
import com.azteklabs.doctorservice.infrastructure.adapter.repository.entity.NameEmbeddable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

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

    List<Doctor> getDoctorsFromEntities(List<DoctorEntity> doctorEntities);

    @Mapping(source = "addressIdentifier.id", target = "id")
    AddressEntity addressToAddressEntity(Address address);

    @Mapping(source = "id", target = "addressIdentifier.id")
    Address addressEntityToAddress(AddressEntity addressEntity);

    NameEmbeddable nameToNameEmbeddable(Name name);

    Name nameEmbeddableToName(NameEmbeddable nameEmbeddable);

    @Mapping(source = "doctorIdentifier.id", target = "id")
    @Mapping(source = "name.firstname", target = "firstname")
    @Mapping(source = "name.lastname", target = "lastname")
    DoctorViewModel doctorToViewModel(Doctor doctor);

    AddressViewModel addressToViewModel(Address address);

    List<String> phoneNumbersToViewModel(List<PhoneNumber> phoneNumbers);
    String phoneNumberToViewModel(PhoneNumber phoneNumber);
}
