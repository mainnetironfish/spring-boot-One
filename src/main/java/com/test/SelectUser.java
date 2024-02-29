package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SelectUser {

    private static String QUERY = "SELECT \"name\", \"uuid\"  FROM lessons.\"User\" WHERE \"uuid\" = ?::uuid";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByUuid(String uuid) {
        User user = jdbcTemplate.queryForObject(QUERY, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {

                User user = new User();
                user.setUuid(resultSet.getString("uuid"));
                user.setName(resultSet.getString("name"));

                return user;
            }
        }, uuid);
        return user;
    }

}
