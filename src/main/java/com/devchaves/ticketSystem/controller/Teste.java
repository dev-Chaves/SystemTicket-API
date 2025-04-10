package com.devchaves.ticketSystem.controller;

import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("teste/")
public class Teste {

    private final UserRepository userRepository;

    public Teste(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    private ResponseEntity<List<UserModel>> findAllUsers(){

        var users = userRepository.findAll();

        return ResponseEntity.ok().body(users);

    }

}
