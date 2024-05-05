package com.project.bank.property.eval.system.repository;

import com.project.bank.property.eval.system.dao.PVSValuationRequestDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository class to perform operations on Property Valuation Request Details Table.
 */
public interface PVSValuationRequestRepository extends JpaRepository<PVSValuationRequestDao, Integer> {

    PVSValuationRequestDao save(PVSValuationRequestDao pvsValuationRequestDao);

    List<PVSValuationRequestDao> findByUserId(int userId);
}
