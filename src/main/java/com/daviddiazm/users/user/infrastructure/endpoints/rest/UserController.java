package com.daviddiazm.users.user.infrastructure.endpoints.rest;

import com.daviddiazm.users.user.application.dtos.requests.SaveUserRequest;
import com.daviddiazm.users.user.application.dtos.responses.SaveUserResponse;
import com.daviddiazm.users.user.application.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    //    http://localhost:8081/swagger-ui/index.html


    private final UserService userService;

    @PostMapping("/")
    ResponseEntity<SaveUserResponse> postUser(SaveUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(request));
    }
}
