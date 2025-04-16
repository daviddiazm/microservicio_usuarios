package com.daviddiazm.users.user.infrastructure.endpoints.rest;

import com.daviddiazm.users.user.application.dtos.requests.SaveUserRequest;
import com.daviddiazm.users.user.application.dtos.responses.SaveUserResponse;
import com.daviddiazm.users.user.application.services.UserService;
import com.daviddiazm.users.user.infrastructure.exceptionshandler.ExceptionResponse;
import com.daviddiazm.users.user.infrastructure.utils.InfrastructureConstans;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(
        name = InfrastructureConstans.USER_TAG,
        description = "The following endpoints are used to create and retrieve departments"
)
//@PreAuthorize("denyAll()")
public class UserController {

    //    http://localhost:8081/swagger-ui/index.html


    private final UserService userService;

    @Operation(
            method = "POST",
            summary = "Save User",
            description = "this endpoint is used to save user",
            parameters = {
                    @Parameter(
                            name = "identification",
                            description = "this area save the identification number",
                            example = "100398774"
                    ),
                    @Parameter(
                            name = "name",
                            description = "the name of the user you want to add",
                            example = "david"
                    ),
                    @Parameter(
                            name = "last name",
                            description = "the last name of the user you want to add",
                            example = "diaz montengro"
                    ),
                    @Parameter(
                            name = "phone number",
                            description = "the phone numebr of the user you want to add to the user",
                            example = "3117672673"
                    ),
                    @Parameter(
                            name = "birth day",
                            description = "the birth dat of the user you want to add",
                            example = "2000-04-18"
                    ),
                    @Parameter(
                            name = "email",
                            description = "this area is for the email you want yo add",
                            example = "david@email.com"
                    ),
                    @Parameter(
                            name = "password",
                            description = "this area is for the password you want yo add",
                            example = "hola123"
                    ),
                    @Parameter(
                            name = "rol user",
                            description = "this area is for the rol user you want yo add",
                            example = "1"
                    ),
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Two text type data are entered",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema( implementation = SaveUserRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The user was successfully saved in the database.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = SaveUserResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Data was entered incorrectly",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = ExceptionResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "enter a user that already exists",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = ExceptionResponse.class)
                            )
                    )
            }

    )
    @PostMapping("/")
    @PreAuthorize("hasAuthority('CREATE_USER')")
    ResponseEntity<SaveUserResponse> postUser(@RequestBody SaveUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(request));
    }

    @GetMapping("/")
//    @PreAuthorize("hasAuthority('READ_HOUSING')")
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<String> prueba() {
        return ResponseEntity.ok().body("hola");
    }
}
