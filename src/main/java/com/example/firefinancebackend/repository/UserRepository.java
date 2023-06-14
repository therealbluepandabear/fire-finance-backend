package com.example.firefinancebackend.repository;

import com.example.firefinancebackend.domain.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> { }
