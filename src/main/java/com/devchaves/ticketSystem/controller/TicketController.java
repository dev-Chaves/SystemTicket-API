package com.devchaves.ticketSystem.controller;

import com.devchaves.ticketSystem.DTOS.TicketDTO.TicketRequestDTO;
import com.devchaves.ticketSystem.models.TicketModel;
import com.devchaves.ticketSystem.services.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket/")
public class TicketController {

    private final TicketService tIcketService;

    public TicketController(TicketService tIcketService) {
        this.tIcketService = tIcketService;
    }

    @Operation(summary = "Create a ticket")
    @PostMapping("create")
    public ResponseEntity createTicket(@RequestBody @Valid TicketRequestDTO ticketDTO){
        return tIcketService.createTicket(ticketDTO);
    }

}
