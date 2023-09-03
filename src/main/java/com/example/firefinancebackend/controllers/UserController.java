package com.example.firefinancebackend.controllers;

import com.example.firefinancebackend.domain.Plan;
import com.example.firefinancebackend.domain.User;
import com.example.firefinancebackend.exceptions.PlanNotFoundException;
import com.example.firefinancebackend.repository.PlanRepository;
import com.example.firefinancebackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.107:3000"})
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUser(userId);

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();

        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
        @RequestParam("email") String email,
        @RequestParam("password") String password
    ) {
        User user = userService.login(email, password);

        return ResponseEntity.ok(user);
    }

    @GetMapping("{userId}/plans")
    public ResponseEntity<Set<Plan>> getPlans(
        @PathVariable Long userId,
        @RequestHeader(name = "Filter-Starred", defaultValue = "false") Boolean filterStarred
    ) {
        Set<Plan> plans = userService.getPlans(userId, filterStarred);

        return ResponseEntity.ok(plans);
    }

    @PostMapping("{userId}/plans")
    public ResponseEntity<?> addPlan(@PathVariable Long userId, @RequestBody Plan plan) {
        userService.addPlan(userId, plan);

        return ResponseEntity.ok().build();
    }
}
