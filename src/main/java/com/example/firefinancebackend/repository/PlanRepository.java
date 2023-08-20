package com.example.firefinancebackend.repository;

import com.example.firefinancebackend.domain.Plan;
import org.springframework.data.repository.ListCrudRepository;

public interface PlanRepository extends ListCrudRepository<Plan, Long> { }
