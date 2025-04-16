package com.devchaves.ticketSystem.util.converterDTOLogic;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConvertFactory {

    private final Map<ConverterKey<?,?>, DTOConverter<?,?>> converters = new HashMap<>();

    public<S, T> void registerConverter(Class<S> sourceType, Class<T> targetType, DTOConverter<S, T> converter){
        converters.put(new ConverterKey<>(sourceType, targetType), converter);
    }

    @SuppressWarnings("unchecked")
    public <S, T> DTOConverter<S, T> getConverter(Class<S> sourceType, Class<T> targetType){

        return (DTOConverter<S, T>) converters.get(new ConverterKey<>(sourceType, targetType));

    }

    public <S, T> T convert (S source, Class<T> targetType){

        if( source == null ) return null;

        @SuppressWarnings("unchecked")
        Class<S> sourceType = (Class<S>) source.getClass();
        DTOConverter<S, T> converter = getConverter(sourceType, targetType);

        if( converter == null ) throw new IllegalArgumentException("No converter registered for " + sourceType + " to " + targetType);

        return converter.convert(source);

    }


    private static class ConverterKey<S, T>{

        private final Class<S> sourceType;
        private final Class<T> targetType;

        public ConverterKey(Class<S> sourceType, Class<T> targetType) {
            this.sourceType = sourceType;
            this.targetType = targetType;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            ConverterKey<?, ?> that = (ConverterKey<?, ?>) o;
            return Objects.equals(sourceType, that.sourceType) && Objects.equals(targetType, that.targetType);
        }

        @Override
        public int hashCode() {
            int result = sourceType.hashCode();
            result = 31 * result + targetType.hashCode();
            return result;
        }
    }

}
