package com.devchaves.ticketSystem.util.converters;

import com.devchaves.ticketSystem.DTOS.UsersDTO.UserCreateDTO;
import com.devchaves.ticketSystem.DTOS.UsersDTO.UserResponseDTO;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.util.converterDTOLogic.DTOConverter;

import java.util.Date;

public class UserModelToResponseConverter implements DTOConverter<UserModel, UserResponseDTO> {

    private final String token;
    private final Date expirationDate;

    public UserModelToResponseConverter(String token, Date expirationDate) {
        this.token = token;
        this.expirationDate = expirationDate;
    }

    @Override
    public UserResponseDTO convert(UserModel source) {
        return new UserResponseDTO(
                source.getUsersName(),
                token,
                expirationDate
        );
    }
}
