package com.devchaves.ticketSystem.util;

public interface DTOConverter<S, T> {
    T convert(S source);
}
