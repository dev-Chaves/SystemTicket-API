package com.devchaves.ticketSystem.util;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class GenerationExpirationDate {


    public Instant generationExpirationDate() {
        return LocalDateTime.now().plusHours(3L).atZone(ZoneId.of(("America/Sao_Paulo"))).toInstant();
    }

}
