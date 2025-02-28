//package com.common.custom.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public DataSource dataSource() {
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setJdbcUrl("jdbc:postgresql://postgres:5432/mydatabase");
//        dataSource.setUsername("myuser");
//        dataSource.setPassword("mypassword");
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        return dataSource;
//    }
//}
