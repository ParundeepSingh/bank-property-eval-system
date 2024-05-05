package com.project.bank.property.eval.system.controller;

import com.project.bank.property.eval.system.model.InitiatorDetails;
import com.project.bank.property.eval.system.service.InitiatorDetailsService;
import com.project.bank.property.eval.system.util.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.project.bank.property.eval.system.configuration.AppConstants.USER_ID;

/**
 * Controller Class having endpoints to fetch Initiator Details.
 */
@RestController
@RequestMapping("/rest")
public class InitiatorDetailsController {

    @Autowired
    private InitiatorDetailsService initiatorDetailsService;

    @Autowired
    private JwtUtility jwtUtility;

    @GetMapping("/initiator-details")
    public ResponseEntity<?> getInitiatorDetails() {
        Map<String, Object> claims = jwtUtility.getClaimsFromAuthenticationHeader();
        String userId = String.valueOf(claims.get(USER_ID));
        InitiatorDetails initiatorDetails = initiatorDetailsService.getInitiatorDetailsByUserId(Integer.valueOf(userId));
        return new ResponseEntity<>(initiatorDetails, HttpStatus.OK);
    }
}
