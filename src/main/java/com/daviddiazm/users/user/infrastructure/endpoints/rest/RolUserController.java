package com.daviddiazm.users.user.infrastructure.endpoints.rest;

import com.daviddiazm.users.user.application.dtos.requests.SaveRolUserRequest;
import com.daviddiazm.users.user.application.dtos.responses.SaveRolUserResponse;
import com.daviddiazm.users.user.application.services.RolUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rol-user")
@RequiredArgsConstructor
public class RolUserController {

    //    http://localhost:8081/swagger-ui/index.html

    private final RolUserService rolUserService;

    @PostMapping("/")
    ResponseEntity<SaveRolUserResponse> postRolUser(SaveRolUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolUserService.saveRol(request));
    }

}
