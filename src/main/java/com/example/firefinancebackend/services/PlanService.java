package com.example.firefinancebackend.services;

import com.example.firefinancebackend.domain.Scenario;

import java.util.List;
import java.util.Map;

public interface PlanService {

    void deletePlan(Long planId);

    void patchPlan(Long planId, Map<String, Object> fields);

    void addScenario(Long planId, Scenario scenario);

    List<Scenario> getScenarios(Long planId);
}
