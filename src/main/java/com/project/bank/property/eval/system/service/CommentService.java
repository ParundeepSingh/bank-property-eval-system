package com.project.bank.property.eval.system.service;


import com.project.bank.property.eval.system.model.comment.Comment;

import java.util.List;

/**
 * Service Interface to perform operations related to Comments.
 */
public interface CommentService {

    List<Comment> save(List<Comment> comments, long pvsValReqId);
}
