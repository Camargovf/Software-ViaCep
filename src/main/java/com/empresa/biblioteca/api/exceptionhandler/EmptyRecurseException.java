package com.empresa.biblioteca.api.exceptionhandler;

public class EmptyRecurseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmptyRecurseException(String message) {
        super(message);
    }


}