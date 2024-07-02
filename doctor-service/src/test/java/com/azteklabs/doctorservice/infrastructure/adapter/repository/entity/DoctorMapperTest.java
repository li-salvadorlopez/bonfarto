package com.azteklabs.doctorservice.infrastructure.adapter.repository.entity;

import com.azteklabs.doctorservice.domain.model.*;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class DoctorMapperTest {

    @Test
    void toEntity() throws Exception {

        List<Address> addresses = List.of(
                new Address(new AddressIdentifier(UUID.randomUUID().toString()),"Ricardo Garcia","Aguascalientes", "Aguascalientes", "20206", "Mexico"),
                new Address(new AddressIdentifier(UUID.randomUUID().toString()),"Cerrada del circo","Aguascalientes", "Aguascalientes", "20218", "Mexico"),
                new Address(new AddressIdentifier(UUID.randomUUID().toString()),"Pedro Perez","Guadalajara", "Jalisco", "30206", "Mexico"),
                new Address(new AddressIdentifier(UUID.randomUUID().toString()),"Vladimir Cool","Moscow", "Moscow", "52006", "Russia"),
                new Address(new AddressIdentifier(UUID.randomUUID().toString()),"Santa Monica Boulevard","Los Angeles", "California", "90210", "USA")
        );
        Doctor doctor = new Doctor(
                new DoctorIdentifier(UUID.randomUUID().toString()),
                new Name("Salvador", "Lopez"),
                addresses
        );

        DoctorEntity doctorEntity = DoctorMapper.INSTANCE.domainToEntity(doctor);

        assertThat(doctorEntity).isNotNull();
        assertThat(doctorEntity.getId()).isEqualTo(doctor.getDoctorIdentifier().id());
        assertThat(doctorEntity.getAddresses().size()).isEqualTo(5);
        for (int i = 0; i < addresses.size(); i++) {
            assertThat(doctorEntity.getAddresses().get(i).getCity()).isEqualTo(doctor.getAddresses().get(i).getCity());
        }
        assertThat(doctorEntity.getName().getFirstname()).isEqualTo(doctor.getName().getFirstname());
        assertThat(doctorEntity.getName().getLastname()).isEqualTo(doctor.getName().getLastname());

    }

    @Test
    void toDomain() {
        List<AddressEntity> addressEntities = List.of(
                new AddressEntity("test1", "Ricardo Garcia","Aguascalientes", "Aguascalientes", "20206", "Mexico"),
                new AddressEntity("test2","Cerrada del circo","Aguascalientes", "Aguascalientes", "20218", "Mexico"),
                new AddressEntity("test3", "Pedro Perez","Guadalajara", "Jalisco", "30206", "Mexico"),
                new AddressEntity("test4","Vladimir Cool","Moscow", "Moscow", "52006", "Russia"),
                new AddressEntity("test5","Santa Monica Boulevard","Los Angeles", "California", "90210", "USA")

        );

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId("testDoctorId");
        doctorEntity.setName(new NameEmbeddable("Salvador", "Lopez"));
        doctorEntity.setCreatedDate(Instant.from(LocalDateTime.now().toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        doctorEntity.setLastModifiedDate(Instant.from(LocalDateTime.now().toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        doctorEntity.setCreatedBy("testUser");
        doctorEntity.setLastModifiedBy("testUser");
        doctorEntity.setAddresses(addressEntities);

        Doctor doctor = DoctorMapper.INSTANCE.entityToDomain(doctorEntity);
        assertThat(doctor).isNotNull();


    }
}