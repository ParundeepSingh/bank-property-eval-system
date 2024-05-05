package com.project.bank.property.eval.system.service.impl;

import com.project.bank.property.eval.system.dao.UserData;
import com.project.bank.property.eval.system.exception.InvalidCredentialsException;
import com.project.bank.property.eval.system.model.login.LoginRequest;
import com.project.bank.property.eval.system.model.login.LoginResponse;
import com.project.bank.property.eval.system.model.register.RegisterRequest;
import com.project.bank.property.eval.system.repository.UserDataRepository;
import com.project.bank.property.eval.system.service.AuthService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtServiceImpl jwtService;

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @SneakyThrows
    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        UserData userData = this.userDataRepository.findByEmailAddress(loginRequest.getEmailAddress());

        if (Objects.isNull(userData)) throw new InvalidCredentialsException("Invalid Credentials !");

        boolean isValidPassword = passwordEncoder.matches(loginRequest.getPassword(), userData.getEncryptedPassword());
        if (!isValidPassword) throw new InvalidCredentialsException("Invalid Credentials !");


        String jwt = jwtService.generateJWT(getClaimsForLoginRequest(userData));

        LoginResponse loginResponse = LoginResponse.builder().build();
        loginResponse.setUserId(userData.getId());
        loginResponse.setUsername(userData.getUserName());
        loginResponse.setEmailAddress(userData.getEmailAddress());
        loginResponse.setToken(jwt);

        return loginResponse;
    }

    private Map<String, Object> getClaimsForLoginRequest(UserData userData) {
        return Map.of(
                "email_address", userData.getEmailAddress(),
                "user_id", userData.getId()
        );
    }

    public void register(RegisterRequest registerRequest) {
        UserData userData = convertRegisterRequestToUserDao(registerRequest);
        userDataRepository.save(userData);
    }

    private UserData convertRegisterRequestToUserDao(RegisterRequest registerRequest) {
        UserData userData = new UserData();
        userData.setUserName(registerRequest.getUsername());
        userData.setEmailAddress(registerRequest.getEmailAddress());
        userData.setEncryptedPassword(passwordEncoder.encode(registerRequest.getPassword()));
        return userData;
    }
}
