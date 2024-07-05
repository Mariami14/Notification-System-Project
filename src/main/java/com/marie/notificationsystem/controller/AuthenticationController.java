package com.marie.notificationsystem.controller;

import com.marie.notificationsystem.DTO.AuthenticationRequest;
import com.marie.notificationsystem.DTO.AuthenticationResponse;
import com.marie.notificationsystem.DTO.RegistrationRequest;
import com.marie.notificationsystem.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final SystemUserService systemUserService;
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()
                    )
            );
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtService.generateToken(userDetails);
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } catch (AuthenticationException e) {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }

    @PostMapping("/register/admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegistrationRequest registrationRequest
    ) {
        return ResponseEntity.ok(authenticationService.registerAdmin(registrationRequest));
    }

    @PostMapping("/register/customer")
    public ResponseEntity<AuthenticationResponse> registerCustomer(
            @RequestBody RegistrationRequest registrationRequest
    ) {
        return ResponseEntity.ok(authenticationService.registerCustomer(registrationRequest));
    }
}
