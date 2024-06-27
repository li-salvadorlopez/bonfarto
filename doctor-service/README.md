# Doctors microservice

### Design and architecture

* [Domain Driven Design](https://martinfowler.com/bliki/DomainDrivenDesign.html)
* [Hexagonal Architecture](https://alistair.cockburn.us/hexagonal-architecture/)
* [C4 Model](https://c4model.com/)
* [Structurizr](https://structurizr.com/)


### Technology stack

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* [Testcontainers](https://docs.spring.io/spring-boot/reference/testing/testcontainers.html)

* [Liquibase](https://docs.liquibase.com/home.html)
* [Docker](https://docs.docker.com/?_gl=1*wjm5sy*_gcl_au*MjA5NzMzODcxNC4xNzE3MDkzOTc4*_ga*NTYyNzE0MjQyLjE3MTcwOTM5Nzg.*_ga_XJWPQMJYHQ*MTcxOTUyMDAxMi45LjEuMTcxOTUyMDAxMy41OS4wLjA)

## Concepts
### Domain Driven Design

| Entities |  Aggregates   | Value Objects | Services | Repositories |  
|----------------|:-------------:|:---------|----------|----|
|[Doctor](./src/main/java/com/azteklabs/doctorservice/domain/model/Doctor.java)| [Doctor](./src/main/java/com/azteklabs/doctorservice/domain/model/Doctor.java)|[DoctorIdentifier](./src/main/java/com/azteklabs/doctorservice/domain/model/DoctorIdentifier.java)| [DoctorsService](./src/main/java/com/azteklabs/doctorservice/domain/model/DoctorsService.java)| [DoctorsRepository](./src/main/java/com/azteklabs/doctorservice/domain/model/DoctorsRepository.java)
|[Address](./src/main/java/com/azteklabs/doctorservice/domain/model/Address.java)|[Address](./src/main/java/com/azteklabs/doctorservice/domain/model/Address.java)|[Name](./src/main/java/com/azteklabs/doctorservice/domain/model/Name.java)
|   | | [AddressIdentifier](./src/main/java/com/azteklabs/doctorservice/domain/model/AddressIdentifier.java)