package com.devchaves.ticketSystem.DTOS.TicketDTO;

import java.time.LocalDateTime;

public class TicketResponseDTO {
    private String userName;
    private String ticketTitle;
    private String ticketDescription;
    private String ticketStatus;
    private String observation;
    private LocalDateTime createdAt;

    public TicketResponseDTO(String userName, String ticketTitle, String ticketDescription, String ticketStatus, String observation, LocalDateTime createdAt) {

        this.userName = userName;
        this.ticketTitle = ticketTitle;
        this.ticketDescription = ticketDescription;
        this.ticketStatus = ticketStatus;
        this.observation = observation;
        this.createdAt = createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
