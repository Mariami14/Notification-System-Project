
package com.marie.notificationsystem.service;

import com.marie.notificationsystem.model.model.SystemUser;
import com.marie.notificationsystem.model.repository.SystemUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SystemUserService implements UserDetailsService {

    private static final String User_Not_Found_MSG = "User with email %s not found";
    private final SystemUserRepository systemUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void signUpUser(SystemUser user) {
        boolean userExists = systemUserRepository.findByEmail(user.getEmail()).isPresent();
        if (userExists) {
            throw new IllegalStateException("Email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        systemUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return systemUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(User_Not_Found_MSG, email)));
    }
}
