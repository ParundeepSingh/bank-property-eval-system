package com.project.bank.property.eval.system.model.login;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

    long userId;

    String username;

    String emailAddress;

    String token;
}
