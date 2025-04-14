package com.devchaves.ticketSystem.util;

import com.devchaves.ticketSystem.DTOS.GenericDTO;

@FunctionalInterface
public interface ConverseDTOFilter {
    boolean test(GenericDTO dto);
}
