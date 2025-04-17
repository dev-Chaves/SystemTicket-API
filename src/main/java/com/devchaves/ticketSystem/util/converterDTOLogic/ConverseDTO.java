package com.devchaves.ticketSystem.util.converterDTOLogic;

import org.springframework.stereotype.Component;

@Component
public class ConverseDTO {

    private final ConverterFactory converterFactory;

    public ConverseDTO(ConverterFactory converterFactory) {
        this.converterFactory = converterFactory;
    }

    public <S, T> T convert(S source, Class<T> targetType){
        return converterFactory.convert(source, targetType);
    }

}
