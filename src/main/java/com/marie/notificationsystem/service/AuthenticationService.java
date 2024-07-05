package com.marie.notificationsystem.service;

import com.marie.notificationsystem.DTO.AuthenticationResponse;
import com.marie.notificationsystem.DTO.RegistrationRequest;
import com.marie.notificationsystem.model.model.SystemUser;
import com.marie.notificationsystem.model.repository.Roles;
import com.marie.notificationsystem.utility.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final SystemUserService systemUserService;
    private final EmailValidator emailValidator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;

    private final String Email_Not_Valid = "Email %s is not valid";

    public AuthenticationResponse registerAdmin(RegistrationRequest registrationRequest) {
        return registerUser(registrationRequest, Roles.ADMIN);
    }

    public AuthenticationResponse registerCustomer(RegistrationRequest registrationRequest) {
        return registerUser(registrationRequest, Roles.CUSTOMER);
    }

    private AuthenticationResponse registerUser(RegistrationRequest registrationRequest, Roles roles) {
        boolean isValidEmail = emailValidator.test(registrationRequest.getEmail());
        if (!isValidEmail) {
            throw new IllegalArgumentException(String.format(Email_Not_Valid, registrationRequest.getEmail()));
        }
        SystemUser newUser = new SystemUser(
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getEmail(),
                bCryptPasswordEncoder.encode(registrationRequest.getPassword()),
                roles
        );
        systemUserService.signUpUser(newUser);

        String token = jwtService.generateToken(newUser);
        return new AuthenticationResponse(token);
    }
}
