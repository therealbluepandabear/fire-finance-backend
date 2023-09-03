package com.example.firefinancebackend.controllers;

import com.example.firefinancebackend.domain.Plan;
import com.example.firefinancebackend.domain.Scenario;
import com.example.firefinancebackend.domain.User;
import com.example.firefinancebackend.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.107:3000"})
@RequestMapping("/api/plans/{planId}")
public class PlanController {

    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @DeleteMapping
    public ResponseEntity<?> deletePlan(@PathVariable Long planId) {
        planService.deletePlan(planId);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<?> patchPlan(@PathVariable Long planId, @RequestBody Map<String, Object> fields) {
        planService.patchPlan(planId, fields);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/scenarios")
    public ResponseEntity<?> addScenario(@PathVariable Long planId, @RequestBody Scenario scenario) {
        planService.addScenario(planId, scenario);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/scenarios")
    public ResponseEntity<List<Scenario>> getScenarios(@PathVariable Long planId)  {
        List<Scenario> scenarios = planService.getScenarios(planId);

        return ResponseEntity.ok(scenarios);
    }
}
