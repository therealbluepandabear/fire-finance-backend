package com.example.firefinancebackend.repository;

import com.example.firefinancebackend.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Long> {

    @Query("FROM User WHERE email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);
}
