package com.ceh.spring.securityoatuth2.securityoatuth2.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
@Configuration
public class LiquibaseConfiguration {
    @Bean
    public SpringLiquibase springLiquibase(DataSource dataSource) {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog("classpath:liquibase/master.xml");
        springLiquibase.setContexts("security");
        springLiquibase.setDefaultSchema(null);
        springLiquibase.setDropFirst(false);
        springLiquibase.setShouldRun(true);
        return springLiquibase;
    }
}
