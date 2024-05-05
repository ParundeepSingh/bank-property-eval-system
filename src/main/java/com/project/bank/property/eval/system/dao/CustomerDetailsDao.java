package com.project.bank.property.eval.system.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * DAO Class for Customer Details Table
 */
@Entity
@Data
@Table(name = "customer_details")
@Accessors(chain = true)
public class CustomerDetailsDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_number")
    private String number;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

}
