package com.project.bank.property.eval.system.repository;

import com.project.bank.property.eval.system.dao.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class to perform operations on User Data Table.
 */
public interface UserDataRepository extends JpaRepository<UserData, Integer> {

    UserData findByEmailAddress(String emailAddress);

    UserData save(UserData userData);
}
