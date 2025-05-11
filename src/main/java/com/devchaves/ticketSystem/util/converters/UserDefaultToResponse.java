package com.devchaves.ticketSystem.util.converters;

import com.devchaves.ticketSystem.DTOS.UsersDTO.UserDefaultResponse;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.util.converterDTOLogic.DTOConverter;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDefaultToResponse implements DTOConverter<UserModel, UserDefaultResponse> {

    private final PasswordEncoder passwordEncoder;

    public UserDefaultToResponse(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDefaultResponse convert(UserModel source) {

        UserDefaultResponse userDefaultResponse = new UserDefaultResponse();

        userDefaultResponse.setUsername(source.getUsersName());
        userDefaultResponse.setUserpass(passwordEncoder.encode(source.getUsersPass()));
        userDefaultResponse.setUsersRole(source.getUsersRole());

        return userDefaultResponse;
    }
}
