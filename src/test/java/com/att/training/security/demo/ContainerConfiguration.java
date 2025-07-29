package com.att.training.security.demo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@TestConfiguration(proxyBeanMethods = false)
public class ContainerConfiguration {
    @ServiceConnection
    @Bean
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>("postgres:16.8");
    }
}

@Target(TYPE)
@Retention(RUNTIME)
@Import(ContainerConfiguration.class)
@interface WithPostgres {}
