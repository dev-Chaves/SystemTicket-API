package com.devchaves.ticketSystem.controller;

import com.devchaves.ticketSystem.DTOS.TicketDTO.TicketRequestToFinish;
import com.devchaves.ticketSystem.DTOS.UsersDTO.UserCreateDTO;
import com.devchaves.ticketSystem.services.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @PutMapping("/updateTicket/{ticketId}")
    public ResponseEntity<?> updateTicketStatus(
            @PathVariable UUID ticketId,
            @RequestBody TicketRequestToFinish ticketDTO) {

        return adminService.updateTicketStatus(ticketId, ticketDTO);
    }


}
