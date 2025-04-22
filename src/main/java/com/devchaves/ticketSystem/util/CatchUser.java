package com.devchaves.ticketSystem.util;

import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.repositories.UserRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;

@Component
public class CatchUser {

    private final UserRepository userRepository;

    public CatchUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            try {
                throw new AccessDeniedException("Usuário não autenticado.");
            } catch (AccessDeniedException e) {
                throw new RuntimeException(e);
            }
        }

        String principal = authentication.getName();

        UserModel currentUser = userRepository.findUserByUsersName(principal).orElseThrow(()-> new RuntimeException("Usuário não encontrado"));

        return currentUser;

    }



}
