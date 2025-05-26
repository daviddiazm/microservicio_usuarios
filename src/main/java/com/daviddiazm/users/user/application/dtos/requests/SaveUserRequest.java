package com.daviddiazm.users.user.application.dtos.requests;

import java.time.LocalDate;

public record SaveUserRequest(
        String identification,
        String name,
        String lastName,
        String phoneNumber,
        LocalDate birthday,
        String email,
        String password,
        Long rolUser
    ) {
}
