package com.devchaves.ticketSystem.DTOS.UsersDTO;

import com.devchaves.ticketSystem.models.RoleEnum;

public class UserDefaultResponse {

    private String username;
    private String userpass;
    private RoleEnum usersRole;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public RoleEnum getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(RoleEnum usersRole) {
        this.usersRole = usersRole;
    }
}
