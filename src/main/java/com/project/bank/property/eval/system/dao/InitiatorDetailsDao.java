package com.project.bank.property.eval.system.dao;


import jakarta.persistence.*;
import lombok.Data;

/**
 * DAO Class for Initiator Details Table
 */
@Entity
@Data
@Table(name = "initiator_details")
public class InitiatorDetailsDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "business_unit")
    private String businessUnit;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "user_id")
    private int userId;
}
