package com.marie.notificationsystem.model.model;


import com.marie.notificationsystem.model.repository.NotificationPreference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private NotificationPreference notificationPreference; // e.g., email, SMS, postal
    private String addressDetails;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "system_user_DB")
    private SystemUser systemUser;



    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }


    public void setUser(SystemUser user) {
        this.systemUser = user;
    }
}
