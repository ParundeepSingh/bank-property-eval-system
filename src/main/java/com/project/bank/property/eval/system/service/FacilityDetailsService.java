package com.project.bank.property.eval.system.service;

import com.project.bank.property.eval.system.model.facility.FacilityDetails;

import java.util.List;

/**
 * Service Interface to perform operations related to Facility Details.
 */
public interface FacilityDetailsService {

    FacilityDetails save(FacilityDetails facilityDetails, long pvsValReqId);

    List<FacilityDetails> getAllByPvsValReqIds(List<Long> pvsValReqIds);
}
