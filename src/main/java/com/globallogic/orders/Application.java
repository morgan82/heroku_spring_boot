package com.globallogic.orders;

import com.globallogic.orders.domain.Order;
import com.globallogic.orders.repository.OrderRepository;
import com.globallogic.orders.service.OrderServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);   // run() devuelve ApplicationContext. Se devuelven los Beans creados
    }
    @Bean
    public CommandLineRunner boostrap(OrderServices service) {
        return (args) -> {
            service.add(new Order("", new Date(), "001", 1));
            service.add(new Order("", new Date(), "002", 1));
            service.add(new Order("", new Date(), "003", 1));
            service.add(new Order("", new Date(), "004", 1));

        };
    }
}