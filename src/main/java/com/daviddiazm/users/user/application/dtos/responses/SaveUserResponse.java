package com.daviddiazm.users.user.application.dtos.responses;

import java.time.LocalDate;

public record SaveUserResponse(String message, LocalDate date) {
}
