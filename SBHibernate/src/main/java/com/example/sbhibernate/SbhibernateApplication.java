package com.example.sbhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SbhibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbhibernateApplication.class, args);
    }

}
