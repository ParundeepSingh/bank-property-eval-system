package com.project.bank.property.eval.system.service.impl;

import com.project.bank.property.eval.system.dao.FacilityDetailsDao;
import com.project.bank.property.eval.system.model.facility.FacilityDetails;
import com.project.bank.property.eval.system.model.facility.types.CCY;
import com.project.bank.property.eval.system.model.facility.types.FacilityType;
import com.project.bank.property.eval.system.repository.FacilityDetailsRepository;
import com.project.bank.property.eval.system.service.FacilityDetailsService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacilityDetailsServiceImpl implements FacilityDetailsService {

    @Autowired
    private FacilityDetailsRepository facilityDetailsRepository;

    @Override
    public FacilityDetails save(FacilityDetails facilityDetails, long pvsValReqId) {

        facilityDetailsRepository.save(
                new FacilityDetailsDao()
                        .setType(facilityDetails.getType().name())
                        .setCategory(facilityDetails.getCategory())
                        .setPurpose(facilityDetails.getPurpose())
                        .setTerm(facilityDetails.getTerm())
                        .setAmount(facilityDetails.getAmount())
                        .setCcy(facilityDetails.getCcy().name())
                        .setIsHousingLoan(facilityDetails.isHousingLoan() ? 1 : 0)
                        .setPvsReqId(pvsValReqId)
        );

        return facilityDetails;
    }

    @Override
    public List<FacilityDetails> getAllByPvsValReqIds(List<Long> pvsValReqIds) {
        List<FacilityDetailsDao> facilityDetailsDaoList = facilityDetailsRepository.findAllByPvsReqId(pvsValReqIds);

        return facilityDetailsDaoList.stream().map(item -> mapFacilityDetailsDaoToModel(item)).collect(Collectors.toList());
    }

    private FacilityDetails mapFacilityDetailsDaoToModel(FacilityDetailsDao facilityDetailsDao){
        return FacilityDetails.builder()
                .type(FacilityType.valueOf(facilityDetailsDao.getType()))
                .category(facilityDetailsDao.getCategory())
                .term(facilityDetailsDao.getTerm())
                .ccy(CCY.valueOf(facilityDetailsDao.getCcy()))
                .purpose(facilityDetailsDao.getPurpose())
                .isHousingLoan(facilityDetailsDao.getIsHousingLoan() == 1)
                .amount(facilityDetailsDao.getAmount())
                .pvsValReqId(facilityDetailsDao.getPvsReqId())
                .build();
    }
}
