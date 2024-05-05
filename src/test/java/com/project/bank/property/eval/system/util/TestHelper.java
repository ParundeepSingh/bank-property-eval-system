package com.project.bank.property.eval.system.util;

import com.project.bank.property.eval.system.dao.UserData;
import com.project.bank.property.eval.system.model.login.LoginRequest;
import com.project.bank.property.eval.system.model.register.RegisterRequest;


public class TestHelper {

    public static LoginRequest getLoginRequest() {
        return LoginRequest.builder()
                .emailAddress("dummy-email@gmail.com")
                .password("dummy-password")
                .build();
    }

    public static UserData getUserData() {
        UserData userData = new UserData();
        userData.setUserName("dummy - username");
        userData.setId(1L);
        userData.setEncryptedPassword("$2a$10$1gOAXY5/vogmVQhHv.E4AOdLturge78JHzFnt9cK2FSZFH/d1C/n.");
        userData.setEmailAddress("dummy-email@gmail.com");

        return userData;
    }


    public static String getJwtToken() {
        return new String("eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAiLCJlbWFpbF9hZGRyZXNzIjoicGFydW5kZWVwQHlhaG9vLmNvbSIsImV4cCI6MTcxNDgxNjQ2MCwidXNlcl9pZCI6MiwiaWF0IjoxNzE0ODE2NDAwfQ.ikazBfvZZsFP8kViJjDbhYH21B63K_hNkrqxnSVvlfM");
    }

    public static RegisterRequest getRegisterRequest() {
        return RegisterRequest.builder()
                .emailAddress("dummy-email@gmail.com")
                .password("dummy-password")
                .username("dummy - username")
                .build();
    }
}
