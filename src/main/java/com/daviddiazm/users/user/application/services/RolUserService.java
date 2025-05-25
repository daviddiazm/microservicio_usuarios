package com.daviddiazm.users.user.application.services;

import com.daviddiazm.users.user.application.dtos.requests.SaveRolUserRequest;
import com.daviddiazm.users.user.application.dtos.responses.RolUserResponse;
import com.daviddiazm.users.user.application.dtos.responses.SaveRolUserResponse;

import java.util.List;

public interface RolUserService {
    SaveRolUserResponse saveRol(SaveRolUserRequest request);
    List<RolUserResponse> getAllRoles();
}
