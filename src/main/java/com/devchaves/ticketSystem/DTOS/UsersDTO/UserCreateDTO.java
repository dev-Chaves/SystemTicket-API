package com.devchaves.ticketSystem.DTOS.UsersDTO;

import com.devchaves.ticketSystem.models.RoleEnum;
import jakarta.validation.constraints.NotEmpty;

public class UserCreateDTO {
    @NotEmpty(message = "Name is required")
    private String usersName;

    @NotEmpty(message = "Password is required")
    private String usersPass;

    @NotEmpty(message = "Role is required")
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
