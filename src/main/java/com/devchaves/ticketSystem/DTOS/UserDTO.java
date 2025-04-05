package com.devchaves.ticketSystem.DTOS;

import com.devchaves.ticketSystem.models.RoleEnum;

import java.util.UUID;

public class UserDTO {
    private UUID userId;
    private String usersName;
    private RoleEnum usersRole;

    // Getters and Setters
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

    public RoleEnum getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(RoleEnum usersRole) {
        this.usersRole = usersRole;
    }
}
