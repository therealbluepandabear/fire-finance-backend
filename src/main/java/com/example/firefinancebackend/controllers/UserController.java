package com.example.firefinancebackend.controllers;

import com.example.firefinancebackend.domain.User;
import com.example.firefinancebackend.exceptions.UserNotFoundException;
import com.example.firefinancebackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity<?> createUser(@RequestBody User user) {
        System.out.println(">>>>>>>>>>>>>>>>>>> got request");

        try {
            userService.createUser(user);

            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);

            return ResponseEntity.ok(user);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
