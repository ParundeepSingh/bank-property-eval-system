package com.project.bank.property.eval.system.repository;

import com.project.bank.property.eval.system.dao.FacilityDetailsDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository class to perform operations on Facility Details Table.
 */
public interface FacilityDetailsRepository extends JpaRepository<FacilityDetailsDao,Integer> {

    FacilityDetailsDao save(FacilityDetailsDao facilityDetailsDao);

    FacilityDetailsDao findByPvsReqId(int pvsReqId);

    @Query(
            value = "SELECT * FROM facility_details fd WHERE fd.pvs_req_id IN ?1",
            nativeQuery = true)
    List<FacilityDetailsDao> findAllByPvsReqId(List<Long> pvsReqId);
}
