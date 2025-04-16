package com.devchaves.ticketSystem.util.converters;

import com.devchaves.ticketSystem.DTOS.TicketDTO.TicketRequestDTO;
import com.devchaves.ticketSystem.models.TicketModel;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.util.converterDTOLogic.DTOConverter;

import java.time.LocalDateTime;

public class TIcketRequestToModelConverter implements DTOConverter<TicketRequestDTO, TicketModel> {

    private final UserModel user;

    public TIcketRequestToModelConverter(UserModel user) {
        this.user = user;
    }

    @Override
    public TicketModel convert(TicketRequestDTO source) {

        TicketModel ticket = new TicketModel();

        ticket.setUser(user);
        ticket.setTicket_title(source.getTicketTitle());
        ticket.setTicket_description(source.getObservation());
        ticket.setTicket_status(source.getTicketStatus());
        ticket.setObservation(source.getObservation());
        ticket.setCreatedAt(LocalDateTime.now());

        return ticket;
    }
}
