package com.devchaves.ticketSystem.util.converterDTOLogic;

public interface DTOConverter<S, T> {
    T convert(S source);
}
