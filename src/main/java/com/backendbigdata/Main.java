package com.backendbigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.backendbigdata"})
@EntityScan(basePackages = {"com.backendbigdata.model"})
//@EnableJpaRepositories(basePackages = {"com.backendbigdata.repository"})
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
