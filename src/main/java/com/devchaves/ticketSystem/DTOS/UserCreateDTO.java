package com.devchaves.ticketSystem.DTOS;

import com.devchaves.ticketSystem.models.RoleEnum;

public class UserCreateDTO {
    private String usersName;
    private String usersPass;
    private RoleEnum usersRole;

    // Getters and Setters
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
}
