package com.example.firefinancebackend.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(PlanNotFoundException.class)
    public ResponseEntity<?> handlePlanNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(InvalidPatchFieldException.class)
    public ResponseEntity<?> handleInvalidPathFieldException() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        System.out.println(e.getMessage());
        return ResponseEntity.internalServerError().build();
    }
}
