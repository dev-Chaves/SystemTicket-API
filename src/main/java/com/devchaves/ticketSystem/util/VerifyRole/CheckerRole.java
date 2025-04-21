package com.devchaves.ticketSystem.util;

import com.devchaves.ticketSystem.models.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class CheckerRole {

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    UserModel user;

    if (principal instanceof UserModel) {
        user = (UserModel) principal;
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
