package com.marie.notificationsystem.service;


import com.marie.notificationsystem.DTO.RegistrationRequest;
import com.marie.notificationsystem.model.model.SystemUser;
import com.marie.notificationsystem.model.repository.Roles;
import com.marie.notificationsystem.utility.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final SystemUserService systemUserService;
    private final EmailValidator emailValidator;

    private final String Email_Not_Valid = "Email %s is not valid";


    public String registerUser(RegistrationRequest registrationRequest, Roles roles) {
        boolean isValidEmail = emailValidator.test(registrationRequest.getEmail());
        if (!isValidEmail) {
            throw new IllegalArgumentException(String.format(Email_Not_Valid, registrationRequest.getEmail()));
        }
        //admin registration
        SystemUser user = new SystemUser(
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                roles
        );
        systemUserService.signUpUser(user);
        return "User registered successfully";
    }

}
