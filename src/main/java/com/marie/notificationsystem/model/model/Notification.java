package com.marie.notificationsystem.model.model;

import com.marie.notificationsystem.model.repository.NotificationStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "notifications")
    @Data
    public class Notification {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "customer_id", referencedColumnName = "id")
        private Customer customer;

        private String message;
        private LocalDateTime sentDateTime;
        @Enumerated(EnumType.STRING)
        private NotificationStatus status;
    }


