package com.azteklabs.billingservice;

import org.springframework.boot.SpringApplication;

public class TestBillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(BillingServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
