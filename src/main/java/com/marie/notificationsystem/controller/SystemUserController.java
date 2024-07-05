/*
package com.marie.notificationsystem.controller;

import com.marie.notificationsystem.DTO.RegistrationRequest;
import com.marie.notificationsystem.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/registration")
@AllArgsConstructor
public class SystemUserController {

    private final RegistrationService registrationService;

    @PostMapping("/register/admin")
    public String registerAdmin(@RequestBody RegistrationRequest registrationRequest) {
        return registrationService.registerAdmin(registrationRequest);
    }

    @PostMapping("/register/customer")
    public String registerCustomer(@RequestBody RegistrationRequest registrationRequest) {
        return registrationService.registerCustomer(registrationRequest);
    }

}
*/
