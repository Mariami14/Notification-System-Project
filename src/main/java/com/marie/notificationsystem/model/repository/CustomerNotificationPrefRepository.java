package com.marie.notificationsystem.model.repository;

import com.marie.notificationsystem.model.model.CustomerNotificationPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerNotificationPrefRepository extends JpaRepository<CustomerNotificationPreferences, Long> {
    CustomerNotificationPreferences findByCustomer_Id(Long customerId);
}
