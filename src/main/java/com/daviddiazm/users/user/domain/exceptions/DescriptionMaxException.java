package com.daviddiazm.users.user.domain.exceptions;

public class DescriptionMaxException extends RuntimeException {
    public DescriptionMaxException(String message) {
        super(message);
    }
}
