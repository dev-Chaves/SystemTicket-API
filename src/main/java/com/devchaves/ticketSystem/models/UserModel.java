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
    private UUID users_id;

    @Column(nullable = false, unique = true)
    private String users_name;

    @Column(nullable = false)
    private String users_pass;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleEnum users_role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketModel> tickets;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentModel> comments;

    public UserModel(UUID users_id, String users_name, String users_pass, RoleEnum users_role, List<TicketModel> tickets, List<CommentModel> comments) {
        this.users_id = users_id;
        this.users_name = users_name;
        this.users_pass = users_pass;
        this.users_role = users_role;
        this.tickets = tickets;
        this.comments = comments;
    }

    public UserModel() {
    }

    public UUID getUsers_id() {
        return users_id;
    }

    public void setUsers_id(UUID users_id) {
        this.users_id = users_id;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getUsers_pass() {
        return users_pass;
    }

    public void setUsers_pass(String users_pass) {
        this.users_pass = users_pass;
    }

    public RoleEnum getUsers_role() {
        return users_role;
    }

    public void setUsers_role(RoleEnum users_role) {
        this.users_role = users_role;
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
