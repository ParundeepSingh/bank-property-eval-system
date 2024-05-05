package com.project.bank.property.eval.system.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


/**
 * DAO Class for Property Valuation Request Table
 */
@Entity
@Data
@Table(name = "pvs_val_requests")
@Accessors(chain = true)
public class PVSValuationRequestDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_id", nullable = false)
    private long requestId;

    @Column(name = "received_datetime", nullable = false)
    private LocalDateTime receivedDateTime;

    @Column(name = "created_datetime", nullable = false)
    private LocalDateTime createdDateTime;

    @Column(name = "modified_datetime", nullable = false)
    private LocalDateTime modifiedDateTime;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "is_active", nullable = false)
    private int isActive;

    @Column(name = "status", nullable = false)
    private int status;
}
