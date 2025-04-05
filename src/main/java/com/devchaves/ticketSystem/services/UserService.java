package com.devchaves.ticketSystem.services;

import com.devchaves.ticketSystem.DTOS.UserCreateDTO;
import com.devchaves.ticketSystem.DTOS.UserResponseDTO;
import com.devchaves.ticketSystem.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public ResponseEntity userLogin(UserCreateDTO userCreateDTO){
        if(userCreateDTO.getUsersName() == null || userCreateDTO.getUsersPass() == null){
            return ResponseEntity.badRequest().body("Invalid Credentials");
        }

        var user = userRepository.findUserByUserName(userCreateDTO.getUsersName()).orElseThrow(() -> new RuntimeException("User Not Found"));

        if(!passwordEncoder.matches(userCreateDTO.getUsersPass(), user.getUsersPass())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = this.tokenService.generateToken(user);

        return new ResponseEntity(new UserResponseDTO(user.getUsersName(), token), HttpStatus.OK);

    }



}
