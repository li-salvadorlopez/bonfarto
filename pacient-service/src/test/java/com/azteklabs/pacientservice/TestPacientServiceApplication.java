package com.azteklabs.pacientservice;

import org.springframework.boot.SpringApplication;

public class TestPacientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(PacientServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
