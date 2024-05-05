package com.project.bank.property.eval.system.controller;


import com.project.bank.property.eval.system.exception.InvalidCredentialsException;
import com.project.bank.property.eval.system.model.login.LoginRequest;
import com.project.bank.property.eval.system.model.login.LoginResponse;
import com.project.bank.property.eval.system.model.register.RegisterRequest;
import com.project.bank.property.eval.system.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for authentication endpoints.
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> getToken(
            @RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = authService.login(loginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest registerRequest){
         authService.register(registerRequest);
        return "SUCCESS";
    }


    @ExceptionHandler({InvalidCredentialsException.class})
    public ResponseEntity<?> handleInvalidCredentialsException(InvalidCredentialsException ex){
        ErrorResponse errorResponse = ErrorResponse.builder(ex,HttpStatus.UNAUTHORIZED, ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleOtherException(Exception ex){
        ErrorResponse errorResponse = ErrorResponse.builder(ex,HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
