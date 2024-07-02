--liquibase formatted sql

--changeset 2024-06-02_10:57:00_doctors-service_create-doctors-table
create table doctors
(
    id                 varchar(255)
        CONSTRAINT doctors_pk PRIMARY KEY,
    firstname             varchar(255) NOT NULL,
    lastname               varchar(255) NOT NULL,
    created_by         varchar(255),
    created_date       timestamp,
    last_modified_by   varchar(255),
    last_modified_date timestamp
)

--changeset 2024-06-02_10:57:00_doctors-service_create-doctor-addresses-table
create table doctor_addresses
(
    id                 varchar(255)
        CONSTRAINT doctor_address_pk PRIMARY KEY,
    doctor_id          varchar(255) references doctors(id),
    street             varchar(255) NOT NULL,
    city               varchar(255) NOT NULL,
    state              varchar(255) NOT NULL,
    zipcode            varchar(255) ,
    country            varchar(255) ,
    created_by         varchar(255),
    created_date       timestamp,
    last_modified_by   varchar(255),
    last_modified_date timestamp
)