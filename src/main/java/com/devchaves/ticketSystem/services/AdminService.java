package com.devchaves.ticketSystem.services;

import com.devchaves.ticketSystem.DTOS.UserCreateDTO;
import com.devchaves.ticketSystem.models.RoleEnum;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private ResponseEntity<UserModel> createUser(@RequestBody UserCreateDTO userDTO){

        if(userDTO.getUsersName() == null || userDTO.getUsersPass() == null){
            return ResponseEntity.badRequest().body(null);
        }

        RoleEnum role = RoleEnum.USER;

        var user = new UserModel();
        user.setUsersName(user.getUsersName());
        user.setUsersPass(passwordEncoder.encode(userDTO.getUsersPass()));
        user.setUsersRole(role);


        userRepository.save(user);

        return ResponseEntity.ok(user);

    }

}
