package com.example.bugtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BugtrackerApplication {

    public static void main(String[] args) {

        SpringApplication.run(BugtrackerApplication.class, args);
    }

}
