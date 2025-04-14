package com.devchaves.ticketSystem.util;

import com.devchaves.ticketSystem.DTOS.GenericDTO;

@FunctionalInterface
public interface ConverseDTO {
    boolean test(GenericDTO dto);
}
