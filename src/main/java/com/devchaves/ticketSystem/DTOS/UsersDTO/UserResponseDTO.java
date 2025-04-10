package com.devchaves.ticketSystem.DTOS.UsersDTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.crypto.Data;
import java.util.Date;

public class UserResponseDTO {
    private String name;
    private String token;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date experationDate;

    public UserResponseDTO(String usersName, String token, Date experationDate) {
        this.name = usersName;
        this.token = token;
        this.experationDate = experationDate;
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

    public Date getExperationDate() {
        return experationDate;
    }

    public void setExperationDate(Date experationDate) {
        this.experationDate = experationDate;
    }
}