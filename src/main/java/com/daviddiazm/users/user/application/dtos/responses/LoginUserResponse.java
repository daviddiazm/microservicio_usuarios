package com.daviddiazm.users.user.application.dtos.responses;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email", "message", "jwt", "status"})
public record LoginUserResponse(String email,  String message, String jwt, boolean status) {
}
