package com.project.bank.property.eval.system.repository;

import com.project.bank.property.eval.system.dao.BorrowerDetailsDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository class to perform operations on Borrower Details Table.
 */
public interface BorrowerDetailsRepository extends JpaRepository<BorrowerDetailsDao, Integer> {

    BorrowerDetailsDao save(BorrowerDetailsDao borrowerDetailsDao);

    @Query(
            value = "SELECT * FROM borrower_details bd WHERE bd.pvs_req_id IN ?1 AND bd.is_main_borrower = 1",
            nativeQuery = true)
    List<BorrowerDetailsDao> findAllMainBorrowersByPvsReqId(List<Long> pvsReqId);
}
