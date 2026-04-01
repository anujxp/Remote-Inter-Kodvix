package com.anuj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfigFile {
    @Bean
    public DriverManagerDataSource myDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring_jdbc_db");
        ds.setUsername("root");
        ds.setPassword("root"); // Use your password
        return ds;
    }

    @Bean
    public JdbcTemplate myJdbcTemplate() {
        return new JdbcTemplate(myDataSource());
    }
}