package com.example.firefinancebackend.repository;

import com.example.firefinancebackend.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> { }
