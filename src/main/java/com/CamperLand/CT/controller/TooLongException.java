package com.CamperLand.CT.controller;

import org.springframework.validation.FieldError;

public class TooLongException extends RuntimeException {
    private FieldError error;

    public TooLongException() {
        super();
    }

    public TooLongException(FieldError error) {
        this.error = error;
    }

    public FieldError getError() {
        return error;
    }
}