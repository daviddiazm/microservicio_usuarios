package com.daviddiazm.users.user.application.services;

import com.daviddiazm.users.user.application.dtos.requests.SaveRolUserRequest;
import com.daviddiazm.users.user.application.dtos.responses.SaveRolUserResponse;

public interface RolUserService {
    SaveRolUserResponse saveRol(SaveRolUserRequest request);
}
