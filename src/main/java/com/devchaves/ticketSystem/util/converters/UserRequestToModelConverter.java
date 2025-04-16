package com.devchaves.ticketSystem.util.converters;

import com.devchaves.ticketSystem.DTOS.UsersDTO.UserCreateDTO;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.util.converterDTOLogic.DTOConverter;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRequestToModelConverter implements DTOConverter<UserCreateDTO, UserModel> {

    private final PasswordEncoder passwordEncoder;

    public UserRequestToModelConverter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserModel convert(UserCreateDTO source) {

        UserModel user = new UserModel();

        user.setUsersName(source.getUsersName());
        user.setUsersPass(passwordEncoder.encode(source.getUsersPass()));
        user.setUsersRole(source.getUsersRole());

        return user;
    }
}
