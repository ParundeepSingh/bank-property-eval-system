package com.project.bank.property.eval.system.service;

import com.project.bank.property.eval.system.model.property.PropertyValuationDetails;

import java.util.List;

/**
 * Service Interface to perform operations related to Property Valuation Details.
 */
public interface PropertyValDetailsService {

    PropertyValuationDetails save(PropertyValuationDetails propertyValuationDetails, long pvsValReqId);

    List<PropertyValuationDetails> getAllByPvsReqIds(List<Long> pvsReqIds);
}
