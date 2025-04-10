package com.devchaves.ticketSystem.DTOS.UsersDTO;

import com.devchaves.ticketSystem.models.RoleEnum;

public class UserRegisterDTO {
    private String usersName;
    private String usersPass;
    private RoleEnum usersRole;
    private String token;

    public UserRegisterDTO(String usersName, String usersPass, String token) {
        this.usersName = usersName;
        this.usersPass = usersPass;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
