package com.marie.notificationsystem.DTO;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isAdmin;
}
