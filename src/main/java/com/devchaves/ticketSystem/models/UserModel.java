package com.devchaves.ticketSystem.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    @Column(nullable = false, unique = true)
    private String usersName;

    @Column(nullable = false)
    private String usersPass;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleEnum usersRole;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketModel> tickets;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentModel> comments;

    public UserModel(UUID userId, String usersName, String usersPass, RoleEnum usersRole, List<TicketModel> tickets, List<CommentModel> comments) {
        this.userId = userId;
        this.usersName = usersName;
        this.usersPass = usersPass;
        this.usersRole = usersRole;
        this.tickets = tickets;
        this.comments = comments;
    }

    public UserModel() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getUsersPass() {
        return usersPass;
    }

    public void setUsersPass(String usersPass) {
        this.usersPass = usersPass;
    }

    public RoleEnum getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(RoleEnum usersRole) {
        this.usersRole = usersRole;
    }

    public List<TicketModel> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketModel> tickets) {
        this.tickets = tickets;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }
}
