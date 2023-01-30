package com.example.springbootrest.exception;

public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException(final String message) {
        super(message);
    }

}
