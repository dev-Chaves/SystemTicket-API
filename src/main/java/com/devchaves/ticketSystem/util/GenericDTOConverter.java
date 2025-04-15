package com.devchaves.ticketSystem.util;

import com.devchaves.ticketSystem.DTOS.GenericDTO;

public class GenericDTOConverter implements DTOConverter<GenericDTO<?>, GenericDTO<?>> {
    @Override
    public GenericDTO<?> convert(GenericDTO<?> source) {
        return new GenericDTO<>(source.getData());
    }
}
