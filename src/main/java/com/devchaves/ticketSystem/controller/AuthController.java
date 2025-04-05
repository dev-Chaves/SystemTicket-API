package com.devchaves.ticketSystem.controller;

import com.devchaves.ticketSystem.DTOS.UserCreateDTO;
import com.devchaves.ticketSystem.DTOS.UserResponseDTO;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.repositories.UserRepository;
import com.devchaves.ticketSystem.services.TokenService;
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

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody UserCreateDTO userCreateDTO){
        if(userCreateDTO.getUsersName() == null || userCreateDTO.getUsersPass() == null){
            return ResponseEntity.badRequest().body("Invalid Credentials");
        }

        var user = userRepository.findUserByUserName(userCreateDTO.getUsersName()).orElseThrow(() -> new RuntimeException("User) Not Found"));

        if(!passwordEncoder.matches(userCreateDTO.getUsersPass(), user.getUsersPass())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = this.tokenService.generateToken(user);

        return new ResponseEntity(new UserResponseDTO(user.getUsersName(), token), HttpStatus.OK);

    }
}
