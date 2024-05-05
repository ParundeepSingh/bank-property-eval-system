package com.project.bank.property.eval.system.service;

import com.project.bank.property.eval.system.model.borrower.Borrower;
import com.project.bank.property.eval.system.model.borrower.BorrowerDetails;

import java.util.List;

/**
 * Service Interface to perform operations related to Borrower Details.
 */
public interface BorrowerDetailsService {

    BorrowerDetails save(BorrowerDetails borrowerDetails, long pvsValReqId);

    List<Borrower> getBorrowerDetails(List<Long> pvsValReqIds);
}
