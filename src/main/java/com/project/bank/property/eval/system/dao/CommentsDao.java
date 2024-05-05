package com.project.bank.property.eval.system.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * DAO Class for Comments Table
 */
@Entity
@Data
@Table(name = "comments")
@Accessors(chain = true)
public class CommentsDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "comment_body")
    private String commentBody;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "comment_datetime")
    private LocalDateTime commentDatetime;

    @Column(name = "pvs_req_id")
    private long pvsReqId;
}
