package com.project.bank.property.eval.system.dao;

import jakarta.persistence.*;
import lombok.Data;

/**
 * DAO Class for User Data Details Table
 */
@Entity
@Data
@Table(name = "user_data")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "encrypted_password", nullable = false)
    private String encryptedPassword;
}
