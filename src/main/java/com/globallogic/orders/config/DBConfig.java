package com.globallogic.orders.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by lmorganti on 01/02/16.
 */
@Slf4j
@Configuration
public class DBConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }
//
//    @Value("${datasource.mine.url}")
//    private String url;
//    @Value("${datasource.mine.username}")
//    private String username;
//    @Value("${datasource.mine.password}")
//    private String password;
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource postgreDataSource() throws URISyntaxException {
//        String dbProperty = System.getProperty("database.url");
//        URI dbUri;
//        BasicDataSource basicDataSource = new BasicDataSource();
//        if (dbProperty != null) {
//            dbUri = new URI(dbProperty);
//            basicDataSource.setUsername(dbUri.getUserInfo().split(":")[0]);
//            basicDataSource.setPassword(dbUri.getUserInfo().split(":")[1]);
//            basicDataSource.setUrl("jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath());
//
//        }else {
//            basicDataSource.setUsername(username);
//            basicDataSource.setPassword(password);
//            basicDataSource.setUrl(url);
//        }
//        log.info("********************************************");
//        log.info("username :"+basicDataSource.getUsername());
//        log.info("password :"+basicDataSource.getPassword());
//        log.info("url :"+basicDataSource.getUrl());
//        return basicDataSource;
//    }

}
