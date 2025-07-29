package com.att.training.security.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.simple.JdbcClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@WithPostgres
class SecurityDemoApplicationTests {
    @Autowired
    private JdbcClient jdbcClient;

    @Test
    void contextLoads() {
        var version = jdbcClient.sql("SELECT VERSION()")
                .query(String.class)
                .single();
        assertThat(version).startsWith("PostgreSQL 16.8 ");
    }
}
