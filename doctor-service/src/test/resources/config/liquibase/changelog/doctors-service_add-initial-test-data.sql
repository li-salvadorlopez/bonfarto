--liquibase formatted sql

--changeset 2024-06-02_10:57:00_doctors-service_insert-doctors-test-data
INSERT INTO doctors (id, firstname, lastname) VALUES ('e2f5b1e0-f38e-4a60-9f39-1e6144e2a1be', 'John', 'Doe');
INSERT INTO doctors (id, firstname, lastname) VALUES ('d2d15f38-d6cf-4b61-b5d5-9f8b76b05f98', 'Jane', 'Smith');
INSERT INTO doctors (id, firstname, lastname) VALUES ('a7a9b6f2-3a49-42a0-95f6-3fa6bb5e9581', 'Michael', 'Johnson');
INSERT INTO doctors (id, firstname, lastname) VALUES ('be8f2cb7-2db9-41c5-b7f7-d6c7f7a1cceb', 'Emily', 'Davis');
INSERT INTO doctors (id, firstname, lastname) VALUES ('9e9a0e3e-5d8e-401d-b7d9-6f5f8e7a1e38', 'David', 'Wilson');
INSERT INTO doctors (id, firstname, lastname) VALUES ('1b9a9f1e-2b7f-4e6b-9f1e-2d6e7f8e5a9c', 'Sarah', 'Taylor');
INSERT INTO doctors (id, firstname, lastname) VALUES ('5c7e1a6b-9f5e-4d6a-8e3e-1d7e7e8a9b5f', 'James', 'Anderson');
INSERT INTO doctors (id, firstname, lastname) VALUES ('8f7e2a9b-3e6d-4b7a-9f5e-3d9f7a6e5a7b', 'Laura', 'Thomas');
INSERT INTO doctors (id, firstname, lastname) VALUES ('6e7a1d6e-2f5b-4e6f-9e3e-2b9a5e8f7e1d', 'Robert', 'Moore');
INSERT INTO doctors (id, firstname, lastname) VALUES ('3e9d2e7f-1a6b-4d5e-9f3e-5a7e6e8b9f1d', 'Linda', 'Brown');

--changeset 2024-06-02_10:57:00_doctors-service_insert-doctors-addresses-test-data
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('1', 'e2f5b1e0-f38e-4a60-9f39-1e6144e2a1be', '123 Elm St', 'Springfield', 'IL', '62701', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('2', 'd2d15f38-d6cf-4b61-b5d5-9f8b76b05f98', '456 Oak St', 'Springfield', 'IL', '62702', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('3', 'd2d15f38-d6cf-4b61-b5d5-9f8b76b05f98', '789 Pine St', 'Chicago', 'IL', '60601', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('4', 'a7a9b6f2-3a49-42a0-95f6-3fa6bb5e9581', '101 Maple St', 'Los Angeles', 'CA', '90001', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('5', 'a7a9b6f2-3a49-42a0-95f6-3fa6bb5e9581', '102 Maple St', 'Los Angeles', 'CA', '90001', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('6', 'be8f2cb7-2db9-41c5-b7f7-d6c7f7a1cceb', '202 Cedar St', 'Houston', 'TX', '77001', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('7', 'be8f2cb7-2db9-41c5-b7f7-d6c7f7a1cceb', '203 Cedar St', 'Houston', 'TX', '77001', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('8', 'be8f2cb7-2db9-41c5-b7f7-d6c7f7a1cceb', '204 Cedar St', 'Houston', 'TX', '77001', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('9', '9e9a0e3e-5d8e-401d-b7d9-6f5f8e7a1e38', '301 Birch St', 'Phoenix', 'AZ', '85001', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('10', '1b9a9f1e-2b7f-4e6b-9f1e-2d6e7f8e5a9c', '401 Walnut St', 'Philadelphia', 'PA', '19019', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('11', '5c7e1a6b-9f5e-4d6a-8e3e-1d7e7e8a9b5f', '501 Ash St', 'San Antonio', 'TX', '78201', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('12', '8f7e2a9b-3e6d-4b7a-9f5e-3d9f7a6e5a7b', '601 Pine St', 'San Diego', 'CA', '92101', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('13', '8f7e2a9b-3e6d-4b7a-9f5e-3d9f7a6e5a7b', '602 Pine St', 'San Diego', 'CA', '92101', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('14', '6e7a1d6e-2f5b-4e6f-9e3e-2b9a5e8f7e1d', '701 Elm St', 'Dallas', 'TX', '75201', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('15', '6e7a1d6e-2f5b-4e6f-9e3e-2b9a5e8f7e1d', '702 Elm St', 'Dallas', 'TX', '75201', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('16', '3e9d2e7f-1a6b-4d5e-9f3e-5a7e6e8b9f1d', '801 Oak St', 'San Jose', 'CA', '95101', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('17', '3e9d2e7f-1a6b-4d5e-9f3e-5a7e6e8b9f1d', '802 Oak St', 'San Jose', 'CA', '95101', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('18', '3e9d2e7f-1a6b-4d5e-9f3e-5a7e6e8b9f1d', '803 Oak St', 'San Jose', 'CA', '95101', 'USA', 'admin', NOW(), 'admin', NOW());
INSERT INTO doctor_addresses (id, doctor_id, street, city, state, zipcode, country, created_by, created_date, last_modified_by, last_modified_date) VALUES ('19', '3e9d2e7f-1a6b-4d5e-9f3e-5a7e6e8b9f1d', '804 Oak St', 'San Jose', 'CA', '95101', 'USA', 'admin', NOW(), 'admin', NOW());
