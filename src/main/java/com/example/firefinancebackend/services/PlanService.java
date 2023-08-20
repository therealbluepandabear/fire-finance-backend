package com.example.firefinancebackend.services;

import com.example.firefinancebackend.domain.Plan;

import java.util.Map;
import java.util.Set;

public interface PlanService {

    void deletePlan(Long planId);

    void patchPlan(Long planId, Map<String, Object> fields);
}
