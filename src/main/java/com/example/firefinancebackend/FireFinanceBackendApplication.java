package com.example.firefinancebackend;

import com.example.firefinancebackend.domain.Plan;
import com.example.firefinancebackend.exceptions.PlanNotFoundException;
import com.example.firefinancebackend.repository.PlanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class FireFinanceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FireFinanceBackendApplication.class, args);
    }
}
