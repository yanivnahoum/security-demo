package com.att.training.security.demo;

import org.springframework.boot.SpringApplication;

public class TestSecurityDemoApplication {
    public static void main(String[] args) {
        SpringApplication.from(SecurityDemoApplication::main)
                .with(ContainerConfiguration.class)
                .run(args);
    }
}
