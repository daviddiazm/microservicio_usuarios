package com.daviddiazm.users.user.domain.exceptions;

public class UnderAgeException extends RuntimeException {
    public UnderAgeException(String message) {
        super(message);
    }
}
