package com.example.firefinancebackend.services;

import com.example.firefinancebackend.domain.User;

interface UserService {

    User createUser(User user);
    User getUserById(Long id);
}
