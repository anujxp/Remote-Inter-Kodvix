package com.codingshuttle.youtube.hospitalManagement.service;

import com.codingshuttle.youtube.hospitalManagement.dto.SignupDto;
import com.codingshuttle.youtube.hospitalManagement.entity.User;
import com.codingshuttle.youtube.hospitalManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signUp(SignupDto signupDto) {
        // Check if user already exists
        if (userRepository.findByUsername(signupDto.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        // Create new user and HASH the password
        User user = User.builder()
                .username(signupDto.getUsername())
                .password(passwordEncoder.encode(signupDto.getPassword()))
                .build();

        return userRepository.save(user);
    }
}