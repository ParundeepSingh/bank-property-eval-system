package com.project.bank.property.eval.system.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


/**
 * DAO Class for Property Valuation Details Table
 */
@Entity
@Data
@Table(name = "property_val_details")
@Accessors(chain = true)
public class PropertyValDetailsDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "application_datetime")
    private LocalDateTime applicationDateTime;

    @Column(name = "pvs_req_id")
    private long pvsReqId;

    @Column(name = "is_fos_ref")
    private int isFosRef;
}
