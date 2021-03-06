/**
 * @(#)DataSourceConfig.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Map;


/**
 * @author Chen Hao
 * @version V1.2.0 16-9-5
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "envDataSource")
    @Qualifier("envDataSource")
    public DataSource envDataSource(){
        String java = System.getenv("JAVA_HOME");
        Map envs = System.getenv();
        System.out.println(envs.toString());
        System.out.println(java);
        return DataSourceBuilder.create().driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/test3").username("root")
                .password("hao119119").build();
    }


    @Bean(name = "defaultDataSource")
    @Qualifier("defaultDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource defaultDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "defaultJdbcTemplate")
    public JdbcTemplate defaultJdbcTemplate(
            @Qualifier("defaultDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "envJdbcTemplate")
    public JdbcTemplate envJdbcTemplate(
            @Qualifier("envDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
