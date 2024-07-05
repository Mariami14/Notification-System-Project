package com.marie.notificationsystem.model.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer_notification_preferences")
@Data
public abstract class CustomerNotificationPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    private boolean smsOptIn;
    private boolean emailOptIn;
    private boolean promotionalOptIn;

    public abstract CustomerNotificationPreferences getPreferencesByCustomerId(Long customerId);

    public abstract void updatePreferences(CustomerNotificationPreferences preferences);
}

