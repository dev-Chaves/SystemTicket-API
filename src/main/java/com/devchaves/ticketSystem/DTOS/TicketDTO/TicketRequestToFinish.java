package com.devchaves.ticketSystem.DTOS.TicketDTO;

import java.util.UUID;

public class TicketFinish {
    private UUID userId;
    private String ticketStatus;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
