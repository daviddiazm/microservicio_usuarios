package com.daviddiazm.users.user.domain.exceptions;

public class NameMaxException extends RuntimeException {
    public NameMaxException(String message) {
        super(message);
    }
}
