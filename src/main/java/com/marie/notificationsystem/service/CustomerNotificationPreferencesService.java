package com.marie.notificationsystem.service;

import com.marie.notificationsystem.model.model.CustomerNotificationPreferences;
import com.marie.notificationsystem.model.repository.CustomerNotificationPrefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerNotificationPreferencesService {

    private final CustomerNotificationPrefRepository preferencesRepository;

    @Autowired
    public CustomerNotificationPreferencesService(CustomerNotificationPrefRepository preferencesRepository) {
        this.preferencesRepository = preferencesRepository;
    }

    public CustomerNotificationPreferences getPreferencesByCustomerId(Long customerId) {
        return preferencesRepository.findByCustomer_Id(customerId);
    }

    public void updatePreferences(CustomerNotificationPreferences preferences) {
        preferencesRepository.save(preferences);
    }
}
