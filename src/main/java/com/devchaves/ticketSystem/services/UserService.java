package com.devchaves.ticketSystem.services;

import com.devchaves.ticketSystem.DTOS.UserCreateDTO;
import com.devchaves.ticketSystem.DTOS.UserRegisterDTO;
import com.devchaves.ticketSystem.DTOS.UserResponseDTO;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        
        UserModel newUser = new UserModel();
        
        newUser.setUsersName(userDTO.getUsersName());
        newUser.setUsersPass(passwordEncoder.encode(userDTO.getUsersPass()));
        this.userRepository.save(newUser);
        
        String token = this.tokenService.generateToken(newUser);
        return ResponseEntity.ok(new UserResponseDTO(newUser.getUsersName(), token));
        
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

        UserResponseDTO responseDTO = new UserResponseDTO(user.getUsersName(), token);

        return ResponseEntity.ok(responseDTO);

    }

}
