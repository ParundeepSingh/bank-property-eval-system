package com.project.bank.property.eval.system.service.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.project.bank.property.eval.system.configuration.JwtConfigurations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.sql.Date;
import java.time.Instant;
import java.util.Map;

@Slf4j
@Service
public class JwtServiceImpl {

    @Autowired
    private JwtConfigurations jwtConfigurations;

    public String generateJWT(Map<String, Object> claims){
        SecretKey secretKey = jwtConfigurations.getKey();
        JWSAlgorithm algorithm = jwtConfigurations.getAlgorithm();

        JWSHeader header = new JWSHeader(algorithm);
        JWTClaimsSet claimsSet = buildClaimSet(claims);

        SignedJWT jwt = new SignedJWT(header,claimsSet);

        try{
            MACSigner signer = new MACSigner(secretKey);
            jwt.sign(signer);
        }
        catch (JOSEException ex){
            throw new RuntimeException("Unable to generate JWT", ex);
        }

        return jwt.serialize();
    }

    private JWTClaimsSet buildClaimSet(Map<String, Object> claims){
        String issuer = jwtConfigurations.getIssuer();
        Instant issuedAt = Instant.now();
        Instant expirationTime = issuedAt.plus(jwtConfigurations.getExpiresIn());

        var builder = new JWTClaimsSet.Builder()
                .issuer(issuer)
                .issueTime(Date.from(issuedAt))
                .expirationTime(Date.from(expirationTime));

        claims.forEach(builder::claim);

        return builder.build();
    }
}
