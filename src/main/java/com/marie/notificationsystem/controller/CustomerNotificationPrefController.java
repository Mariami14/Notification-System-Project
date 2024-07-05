package com.marie.notificationsystem.controller;

import com.marie.notificationsystem.model.model.CustomerNotificationPreferences;
import com.marie.notificationsystem.service.CustomerNotificationPreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/preferences")
public class CustomerNotificationPrefController {

    private final CustomerNotificationPreferencesService preferencesService;

    @Autowired
    public CustomerNotificationPrefController(CustomerNotificationPreferencesService preferencesService) {
        this.preferencesService = preferencesService;
    }

    @GetMapping("/get-preference")
    public ResponseEntity<CustomerNotificationPreferences> getPreferences(@PathVariable Long customerId) {
        CustomerNotificationPreferences preferences = preferencesService.getPreferencesByCustomerId(customerId);
        return ResponseEntity.ok(preferences);
    }

    @PutMapping("/update-preference")
    public ResponseEntity<String> updatePreferences(@PathVariable Long customerId, @RequestBody CustomerNotificationPreferences preferences) {
        preferencesService.updatePreferences(preferences);
        return ResponseEntity.ok("Preferences updated successfully");
    }
}
