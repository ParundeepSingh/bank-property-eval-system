package com.project.bank.property.eval.system.service;

import com.project.bank.property.eval.system.model.login.LoginRequest;
import com.project.bank.property.eval.system.model.login.LoginResponse;
import com.project.bank.property.eval.system.model.register.RegisterRequest;

/**
 * Service Interface to perform Authentication Operations.
 */
public interface AuthService {

    /**
     * Method performs the login
     * @param loginRequest
     * @return
     */
    LoginResponse login(LoginRequest loginRequest);

    /**
     * Method performs a new user registration
     * @param registerRequest
     */
    void register(RegisterRequest registerRequest);
}
