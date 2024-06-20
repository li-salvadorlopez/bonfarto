package com.azteklabs.doctorservice;

import org.springframework.boot.SpringApplication;

public class TestDoctorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(DoctorServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
