package com.marie.notificationsystem.model.repository;

import com.marie.notificationsystem.model.model.SystemUser;
import com.marie.notificationsystem.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public interface SystemUserRepository extends JpaRepository <SystemUser, Long> {
    //generates actual query?
    Optional<SystemUser> findByEmail (String email);
}
