package com.epam.esm.config;

import org.postgresql.Driver;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.util.ClassUtils;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;

@Configuration
public class JdbcConfiguration {
    //    @Bean
//    public JdbcTemplate jdbcTemplate(){
//        return new JdbcTemplate();
//    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/epam1");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root123");
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
