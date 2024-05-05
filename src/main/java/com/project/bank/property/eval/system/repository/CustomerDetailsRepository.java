package com.project.bank.property.eval.system.repository;

import com.project.bank.property.eval.system.dao.CustomerDetailsDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository class to perform operations on Customer Details Table.
 */
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetailsDao,Integer> {

    CustomerDetailsDao save(CustomerDetailsDao customerDetailsDao);

    List<CustomerDetailsDao> findById(long id);

    @Query(
            value = "SELECT * FROM customer_details cd WHERE cd.id IN ?1",
            nativeQuery = true)
    List<CustomerDetailsDao> findAllById(List<Long> ids);
}
