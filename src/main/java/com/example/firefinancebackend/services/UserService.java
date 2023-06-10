package com.example.firefinancebackend.services;

import com.example.firefinancebackend.domain.User;
import com.example.firefinancebackend.exceptions.UserNotFoundException;
import com.example.firefinancebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
