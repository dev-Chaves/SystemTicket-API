package com.devchaves.ticketSystem.services;

import com.devchaves.ticketSystem.DTOS.TicketDTO.TicketRequestDTO;
import com.devchaves.ticketSystem.models.TicketModel;
import com.devchaves.ticketSystem.repositories.TicketRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TIcketService {

    private final TicketRepository ticketRepository;


    public TIcketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public ResponseEntity<TicketModel> createTicket(TicketRequestDTO ticketDTO){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        System.out.println("Username: " + username);

        return null;
    }

}
