package com.globallogic.orders.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.net.URISyntaxException;

/**
 * Created by lmorganti on 01/02/16.
 */
@Slf4j
@Configuration
public class DBConfig {
    //    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//        return new org.apache.tomcat.jdbc.pool.DataSource();
//    }
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws URISyntaxException {
        String url = System.getProperty("database.url");
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        log.info("***********************************************");
        log.info("dbProperty : " + url);
        if (url != null) {
            dataSource.setUrl(url);
        }
        log.info("////////////////////////////////////////////////////");
        return dataSource;
    }

}
