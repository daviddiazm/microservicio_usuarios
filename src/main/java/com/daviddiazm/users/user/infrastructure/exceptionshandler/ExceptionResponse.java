package com.daviddiazm.users.user.infrastructure.exceptionshandler;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime localDateTime) {
}
