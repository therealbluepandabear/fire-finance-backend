package com.example.firefinancebackend.services;

import com.example.firefinancebackend.domain.Plan;
import com.example.firefinancebackend.domain.User;
import com.example.firefinancebackend.exceptions.UserNotFoundException;
import com.example.firefinancebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findUserByEmail(email).orElseThrow(UserNotFoundException::new);

        if (user.getPassword().equals(password)) {
            return user;
        }

        throw new UserNotFoundException();
    }

    @Override
    public Set<Plan> getPlans(Long userId, Boolean filterStarred) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        Set<Plan> plans = user.getPlans();

        if (!filterStarred) {
            return plans;
        } else {
            return plans
                    .stream()
                    .filter(Plan::getIsStarred)
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public void addPlan(Long userId, Plan plan) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        Set<Plan> userPlans = user.getPlans();
        userPlans.add(plan);

        user.setPlans(userPlans);
        plan.setUser(user);

        userRepository.save(user);
    }
}
