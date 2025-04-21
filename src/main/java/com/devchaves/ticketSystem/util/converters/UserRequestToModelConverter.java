package com.devchaves.ticketSystem.util.converters;

import com.devchaves.ticketSystem.DTOS.UsersDTO.UserCreateDTO;
import com.devchaves.ticketSystem.models.RoleEnum;
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

        RoleEnum role = RoleEnum.USER;

        user.setUsersName(source.getUsersName());
        user.setUsersPass(passwordEncoder.encode(source.getUsersPass()));
        user.setUsersRole(role);

        return user;
    }
}
