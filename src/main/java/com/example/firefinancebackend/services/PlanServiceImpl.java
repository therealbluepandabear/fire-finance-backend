package com.example.firefinancebackend.services;

import com.example.firefinancebackend.domain.Plan;
import com.example.firefinancebackend.domain.Scenario;
import com.example.firefinancebackend.exceptions.InvalidPatchFieldException;
import com.example.firefinancebackend.exceptions.PlanNotFoundException;
import com.example.firefinancebackend.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    @Autowired
    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public void deletePlan(Long planId) {
        planRepository.deleteById(planId);
    }

    @Override
    public void patchPlan(Long planId, Map<String, Object> fields) {
        Plan plan = planRepository.findById(planId).orElseThrow(PlanNotFoundException::new);

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Plan.class, key);

            if (field == null) {
                throw new InvalidPatchFieldException();
            }

            field.setAccessible(true);
            ReflectionUtils.setField(field, plan, value);
        });
        
        planRepository.save(plan);
    }

    @Override
    public void addScenario(Long planId, Scenario scenario) {
        Plan plan = planRepository.findById(planId).orElseThrow(PlanNotFoundException::new);

        plan.getScenarios().add(scenario);

        planRepository.save(plan);
    }

    @Override
    public List<Scenario> getScenarios(Long planId) {
        Plan plan = planRepository.findById(planId).orElseThrow(PlanNotFoundException::new);

        return plan.getScenarios();
    }
}
