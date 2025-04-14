package com.devchaves.ticketSystem.util;

import com.devchaves.ticketSystem.DTOS.GenericDTO;

public class ConverseDTO {
    public static GenericDTO convertToGenericDTO(GenericDTO data) {
        return new GenericDTO<>(data.getData());
    }
}
