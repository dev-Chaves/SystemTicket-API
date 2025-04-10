package com.devchaves.ticketSystem.controller;

import com.devchaves.ticketSystem.DTOS.TicketDTO.TicketRequestDTO;
import com.devchaves.ticketSystem.models.TicketModel;
import com.devchaves.ticketSystem.services.TIcketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket/")
public class TicketController {

    private final TIcketService tIcketService;

    public TicketController(TIcketService tIcketService) {
        this.tIcketService = tIcketService;
    }

    @PostMapping("create")
    public ResponseEntity<TicketModel> createTicket(@RequestBody @Valid TicketRequestDTO ticketDTO){
        return tIcketService.createTicket(ticketDTO);
    }

}
