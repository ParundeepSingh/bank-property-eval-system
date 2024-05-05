package com.project.bank.property.eval.system.service.impl;

import com.project.bank.property.eval.system.dao.InitiatorDetailsDao;
import com.project.bank.property.eval.system.model.InitiatorDetails;
import com.project.bank.property.eval.system.repository.InitiatorDetailsRepository;
import com.project.bank.property.eval.system.service.InitiatorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InitiatorDetailsServiceImpl implements InitiatorDetailsService {

    @Autowired
    private InitiatorDetailsRepository initiatorDetailsRepository;

    @Override
    public InitiatorDetails getInitiatorDetailsByUserId(int userId) {
        InitiatorDetailsDao initiatorDetailsDao = initiatorDetailsRepository.findByUserId(userId);
        return InitiatorDetails.builder()
                .name(initiatorDetailsDao.getName())
                .businessUnit(initiatorDetailsDao.getBusinessUnit())
                .contactNumber(initiatorDetailsDao.getContactNumber())
                .build();
    }
}
