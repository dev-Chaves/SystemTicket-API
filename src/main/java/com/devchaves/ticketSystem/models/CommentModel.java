package com.devchaves.ticketSystem.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_comments")
public class CommentModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID comment_id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private TicketModel ticket;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(nullable = false)
    private String comment_text;

    @Column(nullable = false)
    private LocalDateTime created_at;

    // Getters and Setters
}