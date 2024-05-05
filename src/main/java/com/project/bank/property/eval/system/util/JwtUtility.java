package com.project.bank.property.eval.system.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Utility class for JWT Operations.
 */
@Component
public class JwtUtility {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JwtDecoder jwtDecoder;

    /**
     * Method fetches the Authentication Claims from incoming controller requests.
     *
     * @return
     */
    @SneakyThrows
    public Map<String, Object> getClaimsFromAuthenticationHeader() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JsonNode jsonNode = objectMapper.convertValue(authentication.getCredentials(), JsonNode.class);
        JsonNode jsonNode1 = jsonNode.at("/tokenValue");
        String token = jsonNode1.textValue();
        Jwt jwt = jwtDecoder.decode(token);
        return jwt.getClaims();
    }
}
