package com.project.bank.property.eval.system.repository;

import com.project.bank.property.eval.system.dao.InitiatorDetailsDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class to perform operations on Initiator Details Table.
 */
public interface InitiatorDetailsRepository extends JpaRepository<InitiatorDetailsDao, Integer> {

    InitiatorDetailsDao findByUserId(int userId);
}
