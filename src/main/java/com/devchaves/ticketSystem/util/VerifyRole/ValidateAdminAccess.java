package com.devchaves.ticketSystem.util.VerifyRole;

import com.devchaves.ticketSystem.models.UserModel;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;

@Component
public class ValidateAdminAccess implements VerifyRole {

    @Override
    public UserModel checker(Object source) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken) {
            try {
                throw new AccessDeniedException("Usuário não autenticado.");
            } catch (AccessDeniedException e) {
                throw new RuntimeException(e);
            }
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserModel) {
            return (UserModel) principal;
        } else {
            try {
                throw new AccessDeniedException("Tipo de usuário inválido.");
            } catch (AccessDeniedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
