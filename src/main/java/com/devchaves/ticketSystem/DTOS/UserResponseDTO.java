package com.devchaves.ticketSystem.DTOS;

public class UserResponseDTO {
    private String name;
    private String token;

    public UserResponseDTO(String usersName, String token) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}