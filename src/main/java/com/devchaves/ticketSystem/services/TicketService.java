package com.devchaves.ticketSystem.services;

import com.devchaves.ticketSystem.DTOS.TicketDTO.TicketRequestDTO;
import com.devchaves.ticketSystem.DTOS.TicketDTO.TicketResponseDTO;
import com.devchaves.ticketSystem.models.TicketModel;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.repositories.TicketRepository;
import com.devchaves.ticketSystem.util.converterDTOLogic.ConverseDTO;
import com.devchaves.ticketSystem.util.converters.TIcketRequestToModelConverter;
import com.devchaves.ticketSystem.util.converters.TicketModelToResponseConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    private final ConverseDTO converseDTO;

    public TicketService(TicketRepository ticketRepository, ConverseDTO converseDTO) {
        this.ticketRepository = ticketRepository;
        this.converseDTO = converseDTO;
    }

    public ResponseEntity<TicketResponseDTO> createTicket(TicketRequestDTO ticketDTO){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserModel user;

        if (principal instanceof UserModel) {
            user = (UserModel) principal;
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        TIcketRequestToModelConverter converter = new TIcketRequestToModelConverter(user);

        TicketModel ticket = converter.convert(ticketDTO);

        ticketRepository.save(ticket);

        TicketModelToResponseConverter converterResponse = new TicketModelToResponseConverter();

        var response = converterResponse.convert(ticket);

        return ResponseEntity.ok().body(response);
    }

}
