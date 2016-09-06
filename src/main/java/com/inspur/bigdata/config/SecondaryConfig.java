/**
 * @(#)SecondaryConfig.java V1.2.0 16-9-5 
 * Copyright (c) 2014-2016 The inspur Software Foundation.All rights reserved 
 */
package com.inspur.bigdata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;
/**
 * @author Chen Hao
 * @version V1.2.0 16-9-5
 */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef="entityManagerFactorySecondary",
//        transactionManagerRef="transactionManagerSecondary",
//        basePackages= { "com.inspur.bigdata.domain.s" }) //设置Repository所在位置
public class SecondaryConfig {
//
//    @Autowired @Qualifier("secondaryDataSource")
//    private DataSource secondaryDataSource;
//
//    @Bean(name = "entityManagerSecondary")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactorySecondary(builder).getObject().createEntityManager();
//    }
//
//    @Bean(name = "entityManagerFactorySecondary")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary (EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(secondaryDataSource)
//                .properties(getVendorProperties(secondaryDataSource))
//                .packages("com.inspur.bigdata.domain.s") //设置实体类所在位置
//                .persistenceUnit("secondaryPersistenceUnit")
//                .build();
//    }
//
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    private Map<String, String> getVendorProperties(DataSource dataSource) {
//        return jpaProperties.getHibernateProperties(dataSource);
//    }
//
//    @Bean(name = "transactionManagerSecondary")
//    PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
//    }
//

}
