package com.marie.notificationsystem.model.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.marie.notificationsystem.model.repository.NotificationPreference;

import javax.persistence.*;

@Entity
@Table(name = "customer")

public class Customer {

    //TODO: toststing anotacia, getter anotacia
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private NotificationPreference notificationPreference;

    public Customer (){}

    public Customer(@JsonProperty("id") Long id,@JsonProperty("firstName") String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Customer(Long id, String firstName, String lastName, String email, String phoneNumber, NotificationPreference notificationPreference) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.notificationPreference = notificationPreference;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}