package com.marie.notificationsystem.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String notificationPref;
    private final List<Address> addressList;
    private final LocalDateTime createDate;
    private final LocalDateTime updateDate;

    public Customer(Long id, String firstName, String lastName, String email, String phoneNumber, String notificationPref, List<Address> addressList, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.notificationPref = notificationPref;
        this.addressList = addressList;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNotificationPref() {
        return notificationPref;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
}
