package com.project.bank.property.eval.system.service;

import com.project.bank.property.eval.system.model.PvsValuationTask;

import java.util.List;

/**
 * Service Interface to perform operations related to Property Valuation Tasks Details.
 */
public interface PvsValuationTaskService {
    PvsValuationTask createNewPvsValuationTask(int userId);

    List<PvsValuationTask> getAllPvsValuationTask(int userId);
}
