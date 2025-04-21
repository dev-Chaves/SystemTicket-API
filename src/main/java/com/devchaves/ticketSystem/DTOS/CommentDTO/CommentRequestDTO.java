package com.devchaves.ticketSystem.DTOS.CommentDTO;

import java.util.UUID;

public class CommentRequestDTO {
    private UUID ticketId;
    private UUID userId;
    private String commentText;

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

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
