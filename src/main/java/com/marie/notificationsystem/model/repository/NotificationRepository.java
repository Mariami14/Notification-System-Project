package com.marie.notificationsystem.model.repository;

import com.marie.notificationsystem.model.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByCustomerId(Long customerId);
}

