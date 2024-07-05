package com.marie.notificationsystem.service;


import com.marie.notificationsystem.model.model.Customer;
import com.marie.notificationsystem.model.model.Notification;
import com.marie.notificationsystem.model.repository.NotificationRepository;
import com.marie.notificationsystem.model.repository.NotificationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification sendNotification(Customer customer, String message) {
        Notification notification = new Notification();
        notification.setCustomer(customer);
        notification.setMessage(message);
        notification.setSentDateTime(LocalDateTime.now());
        notification.setStatus(NotificationStatus.PENDING);
        return notificationRepository.save(notification);
    }

    @Override
    public void updateNotificationStatus(Long notificationId, NotificationStatus status) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found"));
        notification.setStatus(status);
        notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> getNotificationsByCustomerId(Long customerId) {
        return notificationRepository.findByCustomerId(customerId);
    }
}

