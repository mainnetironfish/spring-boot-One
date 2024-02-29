package com.test;

import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class Config {

    @Bean
    public JdbcTemplate initJdbcTemplate() {
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        simpleDriverDataSource.setDriver(new Driver());
        simpleDriverDataSource.setUsername("postgres");
        simpleDriverDataSource.setPassword("postgres");
        simpleDriverDataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/");
        simpleDriverDataSource.setSchema("lessons");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(simpleDriverDataSource);

        return jdbcTemplate;
    }

}
