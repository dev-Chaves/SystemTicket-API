package com.devchaves.ticketSystem.util.converterDTOLogic;

import com.devchaves.ticketSystem.DTOS.GenericDTO;

public class GenericDTOConverter<T> implements DTOConverter<GenericDTO<?>, GenericDTO<?>> {
    @Override
    public GenericDTO<?> convert(GenericDTO<?> source) {
        return new GenericDTO<>(source.getData());
    }
}
