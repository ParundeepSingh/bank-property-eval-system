package com.project.bank.property.eval.system.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * DAO Class for Facility Details Table
 */
@Entity
@Data
@Table(name = "facility_details")
@Accessors(chain = true)
public class FacilityDetailsDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "category")
    private String category;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "term")
    private long term;

    @Column(name = "ccy")
    private String ccy;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "is_housing_loan")
    private int isHousingLoan;

    @Column(name = "pvs_req_id")
    private long pvsReqId;
}
