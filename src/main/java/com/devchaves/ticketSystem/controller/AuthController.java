package com.devchaves.ticketSystem.controller;

import com.devchaves.ticketSystem.DTOS.UserCreateDTO;
import com.devchaves.ticketSystem.DTOS.UserResponseDTO;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.repositories.UserRepository;
import com.devchaves.ticketSystem.services.TokenService;
import com.devchaves.ticketSystem.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final UserService userService;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService, UserService userService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody UserCreateDTO userCreateDTO) {
        return userService.userLogin(userCreateDTO);
    }

}
