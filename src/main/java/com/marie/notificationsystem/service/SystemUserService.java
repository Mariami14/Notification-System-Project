package com.marie.notificationsystem.service;

import com.marie.notificationsystem.model.repository.SystemUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SystemUserService implements UserDetailsService {
    private static final String User_Not_Found_MSG = "User with email %s not found";


    private final SystemUserRepository systemUserRepository;

    //username is email
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return systemUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format(User_Not_Found_MSG, email)));
    }
}
