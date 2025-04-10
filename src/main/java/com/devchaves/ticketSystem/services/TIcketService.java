package com.devchaves.ticketSystem.services;

import com.devchaves.ticketSystem.DTOS.TicketDTO.TicketRequestDTO;
import com.devchaves.ticketSystem.models.TicketModel;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.repositories.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TIcketService {

    private final TicketRepository ticketRepository;


    public TIcketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public ResponseEntity<TicketModel> createTicket(TicketRequestDTO ticketDTO){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserModel user;

        if (principal instanceof UserModel) {
            user = (UserModel) principal;
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        TicketModel ticket = new TicketModel();
        ticket.setUser(user);
        ticket.setTicket_title(ticketDTO.getTicketTitle());
        ticket.setTicket_description(ticketDTO.getTicketDescription());
        ticket.setTicket_status(ticketDTO.getTicketStatus());
        ticket.setObservation(ticketDTO.getObservation());
        ticket.setCreatedAt(LocalDateTime.now());

        ticketRepository.save(ticket);

        return ResponseEntity.ok(ticket);
    }
}
