package com.project.bank.property.eval.system.service;

import com.project.bank.property.eval.system.model.InitiatorDetails;

/**
 * Service Interface to perform operations related to Initiator Details.
 */
public interface InitiatorDetailsService {

    InitiatorDetails getInitiatorDetailsByUserId(int userId);
}
