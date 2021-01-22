package com.michael.tasque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TasqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasqueApplication.class, args);
    }

}
