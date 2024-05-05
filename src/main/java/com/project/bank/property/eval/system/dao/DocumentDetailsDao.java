package com.project.bank.property.eval.system.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * DAO Class for Document Details Table
 */
@Entity
@Data
@Table(name = "document_details")
@Accessors(chain = true)
public class DocumentDetailsDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "filename")
    private String filename;

    @Column(name = "size")
    private long size;

    @Column(name = "storage_path")
    private String storagePath;

    @Column(name = "uploaded_by")
    private int uploadedBy;

    @Column(name = "uploaded_datetime")
    private LocalDateTime uploadedDatetime;

    @Column(name = "pvs_req_id")
    private long pvsReqId;
}
