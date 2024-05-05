package com.project.bank.property.eval.system.service.impl;

import com.project.bank.property.eval.system.dao.CommentsDao;
import com.project.bank.property.eval.system.model.comment.Comment;
import com.project.bank.property.eval.system.repository.CommentsRepository;
import com.project.bank.property.eval.system.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public List<Comment> save(List<Comment> comments, long pvsValReqId) {

        List<CommentsDao> commentsDaos = new ArrayList<>();
        for (Comment comment : comments) {
            commentsDaos.add(constructCommentDaoFromModel(comment, pvsValReqId));
        }

        commentsRepository.saveAll(commentsDaos);
        return comments;
    }

    private CommentsDao constructCommentDaoFromModel(Comment comment, long pvsValReqId) {
        return new CommentsDao()
                .setCommentBody(comment.getBody())
                .setPvsReqId(pvsValReqId)
                .setCommentDatetime(LocalDateTime.now())
                .setUserId(1);

    }
}
