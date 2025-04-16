package com.devchaves.ticketSystem.util.converterDTOLogic;

import com.devchaves.ticketSystem.DTOS.GenericDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConverterConfig {

    private final PasswordEncoder passwordEncoder;

    public ConverterConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public ConverterFactory converterFactory(){
        ConverterFactory factory = new ConverterFactory();

        factory.registerConverter(GenericDTO.class, GenericDTO.class, new GenericDTOConverter());

        return factory;

    }


}
