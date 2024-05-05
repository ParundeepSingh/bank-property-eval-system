package com.project.bank.property.eval.system.service.impl;

import com.project.bank.property.eval.system.dao.PropertyValDetailsDao;
import com.project.bank.property.eval.system.model.property.PropertyValuationDetails;
import com.project.bank.property.eval.system.model.property.valuation.types.ValuationType;
import com.project.bank.property.eval.system.repository.PropertyValDetailsRepository;
import com.project.bank.property.eval.system.service.PropertyValDetailsService;
import com.project.bank.property.eval.system.util.ReferenceNumUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyValDetailsServiceImpl implements PropertyValDetailsService {

    @Autowired
    private PropertyValDetailsRepository propertyValDetailsRepository;

    @Override
    public PropertyValuationDetails save(PropertyValuationDetails propertyValuationDetails, long pvsValReqId) {
        PropertyValDetailsDao propertyValDetailsDao = propertyValDetailsRepository.save(
                new PropertyValDetailsDao()
                        .setType(propertyValuationDetails.getValuationType().name())
                        .setPvsReqId(pvsValReqId)
                        .setIsFosRef(propertyValuationDetails.isFOSRef() ? 1 : 0)
                        .setApplicationDateTime(LocalDateTime.now())
        );


        return propertyValuationDetails;
    }

    @Override
    public List<PropertyValuationDetails> getAllByPvsReqIds(List<Long> pvsReqIds) {

        List<PropertyValDetailsDao> propertyValDetailsDaoList = propertyValDetailsRepository.findAllByPvsReqId(pvsReqIds);

        return propertyValDetailsDaoList.stream().map(item -> mapPropertyValDetailsDaoToModel(item)).collect(Collectors.toList());
    }

    private PropertyValuationDetails mapPropertyValDetailsDaoToModel(PropertyValDetailsDao propertyValDetailsDao){

        String fosReferenceNumber = ReferenceNumUtility.constructFosReferenceNumber(propertyValDetailsDao.getApplicationDateTime(), propertyValDetailsDao.getId());

        return PropertyValuationDetails.builder()
                .pvsValReqId(propertyValDetailsDao.getPvsReqId())
                .fosRefNum(fosReferenceNumber)
                .isFOSRef(propertyValDetailsDao.getIsFosRef() == 1)
                .valuationType(ValuationType.valueOf(propertyValDetailsDao.getType()))
                .build();
    }
}
