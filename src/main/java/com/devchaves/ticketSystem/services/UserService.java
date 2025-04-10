package com.devchaves.ticketSystem.services;

import com.devchaves.ticketSystem.DTOS.UsersDTO.UserCreateDTO;
import com.devchaves.ticketSystem.DTOS.UsersDTO.UserRegisterDTO;
import com.devchaves.ticketSystem.DTOS.UsersDTO.UserResponseDTO;
import com.devchaves.ticketSystem.models.RoleEnum;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Value("${admin.token}")
    private String expectedAdminToken;

    public ResponseEntity<UserResponseDTO> userLogin(UserCreateDTO userDTO){

        validateLoginCredentials(userDTO);

        UserModel user = findValidateUser(userDTO);

        return buildResponse(user);

    }

    public ResponseEntity<UserResponseDTO> userRegister(UserRegisterDTO userDTO){
        Optional<UserModel> user = userRepository.findUserByUsersName(userDTO.getUsersName());

        if(user.isPresent()){
            return ResponseEntity.badRequest().body(null);
        }

        RoleEnum role = RoleEnum.ADMIN;

        if(userDTO.getToken() == null || !userDTO.getToken().equals(expectedAdminToken)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }


        UserModel newUser = new UserModel();
        
        newUser.setUsersName(userDTO.getUsersName());
        newUser.setUsersPass(passwordEncoder.encode(userDTO.getUsersPass()));
        newUser.setUsersRole(role);
        this.userRepository.save(newUser);
        
        String token = this.tokenService.generateToken(newUser);
        Date dateExperation = this.tokenService.getDateExperation(token);
        return ResponseEntity.ok(new UserResponseDTO(newUser.getUsersName(), token, dateExperation));
        
    }

    private void validateLoginCredentials(UserCreateDTO userDTO){
        if(userDTO.getUsersName() == null || userDTO.getUsersPass() == null){
            throw new RuntimeException("Invalid Credentials");
        }
    }

    private UserModel findValidateUser(UserCreateDTO userDTO){
        var user = userRepository.findUserByUsersName(userDTO.getUsersName()).orElseThrow(() -> new RuntimeException("User Not Found"));

        if(!passwordEncoder.matches(userDTO.getUsersPass(), user.getUsersPass())){
            throw new RuntimeException("Invalid Credentials");
        }

        return user;
    }

    private ResponseEntity<UserResponseDTO> buildResponse(UserModel user){
        String token = this.tokenService.generateToken(user);

        Date dateExperation = this.tokenService.getDateExperation(token);

        UserResponseDTO responseDTO = new UserResponseDTO(user.getUsersName(), token, dateExperation);

        return ResponseEntity.ok(responseDTO);

    }

}
