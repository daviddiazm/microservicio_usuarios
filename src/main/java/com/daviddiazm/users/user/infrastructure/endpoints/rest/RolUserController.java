package com.daviddiazm.users.user.infrastructure.endpoints.rest;

import com.daviddiazm.users.user.application.dtos.requests.SaveRolUserRequest;
import com.daviddiazm.users.user.application.dtos.responses.RolUserResponse;
import com.daviddiazm.users.user.application.dtos.responses.SaveRolUserResponse;
import com.daviddiazm.users.user.application.services.RolUserService;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/rol-user")
@RequiredArgsConstructor
@Tag(
        name = InfrastructureConstans.USER_TAG,
        description = "The following endpoints are used to create and retrieve rol users"
)
public class RolUserController {

    //    http://localhost:8081/swagger-ui/index.html

    private final RolUserService rolUserService;

    @Operation(
            method = "POST",
            summary = "Save rol user",
            description = "this endpoint is used to save rol user",
            parameters = {
                    @Parameter(
                            name = "name",
                            description = "the name of the rol user you want to add",
                            example = "vendedor"
                    ),
                    @Parameter(
                            name = "description",
                            description = "this area is for the description you want yo add",
                            example = "es la persona que vende cosas"
                    ),
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Two text type data are entered",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema( implementation = SaveRolUserRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The rol user was successfully saved in the database.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = SaveRolUserResponse.class)
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
                            description = "enter a rol user that already exists",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema( implementation = ExceptionResponse.class)
                            )
                    )
            }

    )
    @PostMapping("/")

    ResponseEntity<SaveRolUserResponse> postRolUser(@RequestBody SaveRolUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolUserService.saveRol(request));
    }


    @GetMapping("/")
    ResponseEntity<List<RolUserResponse>> getAllRoles (  ){
        return ResponseEntity.ok().body(rolUserService.getAllRoles());
    }

}
