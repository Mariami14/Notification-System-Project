package com.marie.notificationsystem.service;

import com.marie.notificationsystem.model.model.Customer;
import com.marie.notificationsystem.model.model.Notification;
import com.marie.notificationsystem.model.repository.NotificationStatus;

import java.util.List;

    public interface NotificationService {
        Notification sendNotification(Customer customer, String message);
        void updateNotificationStatus(Long notificationId, NotificationStatus status);
        List<Notification> getAllNotifications();
        List<Notification> getNotificationsByCustomerId(Long customerId);
    }


