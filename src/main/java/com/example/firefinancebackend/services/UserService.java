package com.example.firefinancebackend.services;

import com.example.firefinancebackend.domain.Plan;
import com.example.firefinancebackend.domain.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User createUser(User user);

    User getUser(Long id);

    List<User> getUsers();

    User login(String email, String password);

    Set<Plan> getPlans(Long userId, Boolean filterStarred);

    void addPlan(Long userId, Plan plan);
}
