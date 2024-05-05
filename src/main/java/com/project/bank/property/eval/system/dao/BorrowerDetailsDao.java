package com.project.bank.property.eval.system.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * DAO Class for BorrowerDetails Table
 */
@Entity
@Data
@Table(name = "borrower_details")
@Accessors(chain = true)
public class BorrowerDetailsDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "is_main_borrower")
    private int isMainBorrower;

    @Column(name = "pvs_req_id")
    private long pvsReqId;
}
