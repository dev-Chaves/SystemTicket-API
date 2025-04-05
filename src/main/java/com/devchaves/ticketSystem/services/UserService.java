package com.devchaves.ticketSystem.services;

import com.devchaves.ticketSystem.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



}
