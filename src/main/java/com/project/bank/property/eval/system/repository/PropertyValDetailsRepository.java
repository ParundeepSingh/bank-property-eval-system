package com.project.bank.property.eval.system.repository;

import com.project.bank.property.eval.system.dao.PropertyValDetailsDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository class to perform operations on Property Valuation Details Table.
 */
public interface PropertyValDetailsRepository extends JpaRepository<PropertyValDetailsDao,Integer> {

    PropertyValDetailsDao save(PropertyValDetailsDao propertyEvalDetailsDao);

    @Query(
            value = "SELECT * FROM property_val_details pvd WHERE pvd.pvs_req_id IN ?1",
            nativeQuery = true)
    List<PropertyValDetailsDao> findAllByPvsReqId(List<Long> pvsReqIds);

}
