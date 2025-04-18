package com.devchaves.ticketSystem.util.converterDTOLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConverseDTO {

    private final ConverterFactory converterFactory;

    @Autowired
    public ConverseDTO(ConverterFactory converterFactory) {
        this.converterFactory = converterFactory;
    }

    public <S, T> T convert(S source, Class<T> targetType){
        return converterFactory.convert(source, targetType);
    }

}
