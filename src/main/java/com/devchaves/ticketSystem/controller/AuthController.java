package com.devchaves.ticketSystem.controller;

import com.devchaves.ticketSystem.DTOS.UsersDTO.UserCreateDTO;
import com.devchaves.ticketSystem.DTOS.UsersDTO.UserDTO;
import com.devchaves.ticketSystem.DTOS.UsersDTO.UserRegisterDTO;
import com.devchaves.ticketSystem.services.AdminService;
import com.devchaves.ticketSystem.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/")
public class AuthController {

    private final UserService userService;
    private final AdminService adminService;

    public AuthController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }

    @Operation(summary = "Login user")
    @PostMapping("login")
    public ResponseEntity login(@RequestBody UserDTO dto) {
        return userService.userLogin(dto);
    }

    @Operation(summary = "Register user, only for admin with tokens valid")
    @PostMapping("register")
    public ResponseEntity register(@RequestBody UserRegisterDTO userDTO){
        return userService.userRegister(userDTO);
    }

}
