package com.att.training.security.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDao {
    private static final String FIND_BY_NAME_SQL = """
            SELECT id, name
            FROM app.users
            WHERE name = '%s'
            """;
    private final JdbcTemplate jdbcTemplate;
    private final JdbcClient jdbcClient;

    public List<User> findByName(String name) {
        // This SQL injection is identified correctly by Veracode
        return jdbcTemplate.query(FIND_BY_NAME_SQL.formatted(name), this::mapToUser);
    }

    public List<User> findByName2(String name) {
        // This SQL injection is NOT picked up by Veracode
        return jdbcClient.sql(FIND_BY_NAME_SQL.formatted(name))
                .query(this::mapToUser)
                .list();
    }

    private User mapToUser(ResultSet resultSet, int num) throws SQLException {
        return new User(
                resultSet.getLong("id"),
                resultSet.getString("name")
        );
    }
}
