package com.devchaves.ticketSystem.controller;

import com.devchaves.ticketSystem.DTOS.UsersDTO.UserCreateDTO;
import com.devchaves.ticketSystem.services.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/")
public class AdminController {

    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Operation(summary = "Create user, only for admin with tokens valid")
    @PostMapping("createUser")
    public ResponseEntity createUser(@RequestBody @Valid UserCreateDTO userDTO){
        return adminService.createUser(userDTO);
    }

}
