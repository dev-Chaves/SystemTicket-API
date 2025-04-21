package com.devchaves.ticketSystem.services;

import com.devchaves.ticketSystem.DTOS.TicketDTO.TicketRequestToFinish;
import com.devchaves.ticketSystem.DTOS.TicketDTO.TicketResponseDTO;
import com.devchaves.ticketSystem.DTOS.UsersDTO.UserCreateDTO;
import com.devchaves.ticketSystem.DTOS.UsersDTO.UserDefaultResponse;
import com.devchaves.ticketSystem.models.RoleEnum;
import com.devchaves.ticketSystem.models.TicketModel;
import com.devchaves.ticketSystem.models.UserModel;
import com.devchaves.ticketSystem.repositories.TicketRepository;
import com.devchaves.ticketSystem.repositories.UserRepository;
import com.devchaves.ticketSystem.util.converterDTOLogic.ConverseDTO;
import com.devchaves.ticketSystem.util.converters.TicketModelToResponseConverter;
import com.devchaves.ticketSystem.util.converters.UserDefaultToResponse;
import com.devchaves.ticketSystem.util.converters.UserModelToResponseConverter;
import com.devchaves.ticketSystem.util.converters.UserRequestToModelConverter;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TicketRepository ticketRepository;
    private final ConverseDTO converseDTO;

    public AdminService(UserRepository userRepository, PasswordEncoder passwordEncoder, TicketRepository ticketRepository, ConverseDTO converseDTO) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.ticketRepository = ticketRepository;
        this.converseDTO = converseDTO;
    }

    public ResponseEntity<UserDefaultResponse> createUser(@RequestBody UserCreateDTO userDTO){

        if(userDTO.getUsersName() == null || userDTO.getUsersPass() == null){
            return ResponseEntity.badRequest().body(null);
        }

        var userDB = new UserModel();

        UserRequestToModelConverter converter = new UserRequestToModelConverter(passwordEncoder);

        userDB = converter.convert(userDTO);

        UserDefaultToResponse converterTeste = new UserDefaultToResponse(passwordEncoder);

        var response = converterTeste.convert(userDB);

        userRepository.save(userDB);

        return ResponseEntity.ok().body(response);

    }

    public ResponseEntity<?> finishTicket(@RequestBody @Valid TicketRequestToFinish ticketDTO){

        if(ticketDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Optional<TicketModel> ticket = ticketRepository.findById(ticketDTO.getUserId());

        if(!ticket.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket Not Found!");
        }

        TicketModel ticketUpdate = ticket.get();

        ticketUpdate.setTicket_status(ticketDTO.getTicketStatus());

        ticketRepository.save(ticketUpdate);

        TicketModelToResponseConverter converter = new TicketModelToResponseConverter();

        var response = converter.convert(ticketUpdate);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
