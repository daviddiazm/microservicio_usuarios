package com.daviddiazm.users.user.domain.exceptions;

public class InvalidEmialException extends RuntimeException {
    public InvalidEmialException(String message) {
        super(message);
    }
}
