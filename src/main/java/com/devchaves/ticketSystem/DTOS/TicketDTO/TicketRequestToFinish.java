package com.devchaves.ticketSystem.DTOS.TicketDTO;

import com.devchaves.ticketSystem.models.TicketStatus;

import java.util.UUID;

public class TicketRequestToFinish {
    private UUID userId;
    private UUID ticketId;
    private TicketStatus ticketStatus;

    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
