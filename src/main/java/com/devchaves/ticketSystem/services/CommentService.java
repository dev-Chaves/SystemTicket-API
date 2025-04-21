package com.devchaves.ticketSystem.services;

import com.devchaves.ticketSystem.repositories.CommenetRepository;
import com.devchaves.ticketSystem.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommenetRepository commenetRepository;
    private final UserRepository userRepository;

    public CommentService(CommenetRepository commenetRepository, UserRepository userRepository) {
        this.commenetRepository = commenetRepository;
        this.userRepository = userRepository;
    }



}
