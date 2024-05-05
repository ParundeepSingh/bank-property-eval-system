package com.project.bank.property.eval.system.service.impl;

import com.project.bank.property.eval.system.dao.UserData;
import com.project.bank.property.eval.system.model.login.LoginRequest;
import com.project.bank.property.eval.system.model.login.LoginResponse;
import com.project.bank.property.eval.system.model.register.RegisterRequest;
import com.project.bank.property.eval.system.repository.UserDataRepository;
import com.project.bank.property.eval.system.util.TestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock
    private UserDataRepository userDataRepository;

    @Mock
    private JwtServiceImpl jwtService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthServiceImpl authService;

    @DisplayName("Test Login Method")
    @Test
    void login() {
        //Arrange
        LoginRequest loginRequest = TestHelper.getLoginRequest();
        UserData userData = TestHelper.getUserData();

        //Act
        when(userDataRepository.findByEmailAddress(loginRequest.getEmailAddress())).thenReturn(userData);
        when(passwordEncoder.matches(loginRequest.getPassword(), userData.getEncryptedPassword())).thenReturn(true);
        when(jwtService.generateJWT(anyMap())).thenReturn(TestHelper.getJwtToken());

        LoginResponse loginResponse = authService.login(loginRequest);

        //Assert
        assertEquals(TestHelper.getJwtToken(), loginResponse.getToken());
    }

    @Test
    void register() {
        //Arrange
        RegisterRequest registerRequest = TestHelper.getRegisterRequest();
        UserData userData = new UserData();

        //Act
        when(userDataRepository.save(any())).thenReturn(userData);
        authService.register(registerRequest);

        //Assert
        verify(userDataRepository, times(1)).save(any());
    }
}