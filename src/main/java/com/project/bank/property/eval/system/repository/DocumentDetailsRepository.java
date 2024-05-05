package com.project.bank.property.eval.system.repository;

import com.project.bank.property.eval.system.dao.DocumentDetailsDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class to perform operations on Document Details Table.
 */
public interface DocumentDetailsRepository extends JpaRepository<DocumentDetailsDao,Integer> {

    DocumentDetailsDao save(DocumentDetailsDao documentDetailsDao);
}
