package com.project.bank.property.eval.system.service;

import com.project.bank.property.eval.system.model.PvsValuationRequestItem;
import com.project.bank.property.eval.system.model.pvs.val.request.PvsValRequestDetails;

import java.util.List;

/**
 * Service Interface to perform operations related to Property Valuation Requests Details.
 */
public interface PvsValRequestService {

    boolean submitPvsValRequest(PvsValRequestDetails pvsValRequestDetails, int userId);

    List<PvsValuationRequestItem> getAllPvsValuationRequestItem(int userId);
}
