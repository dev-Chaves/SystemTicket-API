package com.devchaves.ticketSystem.DTOS;

import java.util.List;

public class GenericDTO<T> {
    private T data;
    private List<String> errors;
    private String message;
    private int statusCode;

    public GenericDTO(T data, List<String> errors, String message, int statusCode) {
        this.data = data;
        this.errors = errors;
        this.message = message;
        this.statusCode = statusCode;
    }

    public GenericDTO(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}


