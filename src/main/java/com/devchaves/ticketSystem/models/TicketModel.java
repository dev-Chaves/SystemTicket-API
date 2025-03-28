package com.devchaves.ticketSystem.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_tickets")
public class TicketModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ticket_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(nullable = false)
    private String ticket_title;

    @Column(nullable = false)
    private String ticket_description;

    @Column(nullable = false)
    private String ticket_status;

    @Column(nullable = false)
    private String observation;

    @Column(nullable = false)
    private LocalDateTime createdAt;


}
