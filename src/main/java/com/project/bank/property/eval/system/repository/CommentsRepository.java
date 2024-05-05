package com.project.bank.property.eval.system.repository;

import com.project.bank.property.eval.system.dao.CommentsDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class to perform operations on Comments Table.
 */
public interface CommentsRepository extends JpaRepository<CommentsDao,Integer> {
    CommentsDao save(CommentsDao commentsDao);

}
