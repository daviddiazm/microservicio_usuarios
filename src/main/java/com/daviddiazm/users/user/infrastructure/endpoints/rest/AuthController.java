package com.daviddiazm.users.user.infrastructure.endpoints.rest;

import com.daviddiazm.users.user.application.dtos.requests.LoginUserRequest;
import com.daviddiazm.users.user.application.dtos.responses.LoginUserResponse;
import com.daviddiazm.users.user.infrastructure.security.UserDetailServiceImp;
import com.daviddiazm.users.user.infrastructure.utils.InfrastructureConstans;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(
        name = InfrastructureConstans.USER_TAG,
        description = "The following endpoints are used to create and retrieve rol users"
)
public class AuthController {

    //    http://localhost:8081/swagger-ui/index.html


    private final UserDetailServiceImp userDetailServiceImp;

    @PostMapping("/")
    ResponseEntity<LoginUserResponse> login (@RequestBody LoginUserRequest request ) {
        return ResponseEntity.ok().body(userDetailServiceImp.loginUser(request));
    }
}
