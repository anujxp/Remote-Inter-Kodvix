package com.codingshuttle.youtube.hospitalManagement.controller;


import com.codingshuttle.youtube.hospitalManagement.dto.SignupDto;
import com.codingshuttle.youtube.hospitalManagement.entity.User;
import com.codingshuttle.youtube.hospitalManagement.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignupDto signupDto) {
        User user = authService.signUp(signupDto);
        return ResponseEntity.ok(user);
    }
}