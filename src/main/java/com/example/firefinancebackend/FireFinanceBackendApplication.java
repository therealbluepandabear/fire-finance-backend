package com.example.firefinancebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class FireFinanceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FireFinanceBackendApplication.class, args);
    }

}
