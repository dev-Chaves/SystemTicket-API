package com.devchaves.ticketSystem.util.converters;

import com.devchaves.ticketSystem.DTOS.TicketDTO.TicketResponseDTO;
import com.devchaves.ticketSystem.models.TicketModel;
import com.devchaves.ticketSystem.util.converterDTOLogic.DTOConverter;

public class TicketModelToResponseConverter implements DTOConverter<TicketModel, TicketResponseDTO> {
    @Override
    public TicketResponseDTO convert(TicketModel source) {

        return new TicketResponseDTO(
                source.getUser().getUsersName(),
                source.getTicket_title(),
                source.getTicket_description(),
                source.getTicket_status(),
                source.getObservation(),
                source.getCreatedAt()
        );
    }
}
