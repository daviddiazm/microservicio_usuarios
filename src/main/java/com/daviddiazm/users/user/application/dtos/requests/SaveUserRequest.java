package com.daviddiazm.users.user.application.dtos.requests;

import java.time.LocalDate;

public record SaveUserRequest(
        String name,
        String lastName,
        LocalDate birthDay,
        String email,
        String password,
        Long rolUser
    ) {
}
