package com.daviddiazm.users.user.application.services;

import com.daviddiazm.users.user.application.dtos.requests.SaveUserRequest;
import com.daviddiazm.users.user.application.dtos.responses.SaveUserResponse;

public interface UserService {
    SaveUserResponse saveUser(SaveUserRequest saveUserRequest);
}
