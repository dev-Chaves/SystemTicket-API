package com.devchaves.ticketSystem.services;

import com.devchaves.ticketSystem.DTOS.CommentDTO.CommentRequestDTO;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.repositories.CommenetRepository;
import com.devchaves.ticketSystem.repositories.UserRepository;
import com.devchaves.ticketSystem.util.CatchUser;
import com.devchaves.ticketSystem.util.VerifyRole.ValidateAdminAccess;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CommentService {

    private final CommenetRepository commenetRepository;
    private final UserRepository userRepository;
    private final ValidateAdminAccess checkerRole;
    private final CatchUser catchUser;

    public CommentService(CommenetRepository commenetRepository, UserRepository userRepository, ValidateAdminAccess checkerRole, CatchUser catchUser) {
        this.commenetRepository = commenetRepository;
        this.userRepository = userRepository;
        this.checkerRole = checkerRole;
        this.catchUser = catchUser;
    }

    public ResponseEntity<?> makeComment(@RequestBody CommentRequestDTO commentDTO){

        catchUser.getCurrentUser();

        return null;

    }

}
