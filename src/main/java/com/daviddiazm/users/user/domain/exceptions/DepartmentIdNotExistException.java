package com.daviddiazm.users.user.domain.exceptions;

public class DepartmentIdNotExistException extends RuntimeException {
    public DepartmentIdNotExistException(String message) {
        super(message);
    }
}
