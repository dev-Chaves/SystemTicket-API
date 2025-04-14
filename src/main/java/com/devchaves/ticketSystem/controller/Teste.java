package com.devchaves.ticketSystem.controller;

import com.devchaves.ticketSystem.DTOS.UsersDTO.UserDTO;
import com.devchaves.ticketSystem.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("teste/")
public class Teste {

    private final UserRepository userRepository;

    public Teste(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    private ResponseEntity<List<UserDTO>> findAllUsers(){

        var users = userRepository.findAll();

        List<UserDTO> userDTOS = users.stream().map(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(user.getUserId());
            userDTO.setUsersName(user.getUsersName());
            userDTO.setUsersRole(user.getUsersRole());

            return userDTO;

        }).collect(Collectors.toList());

        return ResponseEntity.ok(userDTOS);
    }

}
