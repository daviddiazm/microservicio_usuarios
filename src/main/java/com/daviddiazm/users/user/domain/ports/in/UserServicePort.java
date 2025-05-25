package com.daviddiazm.users.user.domain.ports.in;

import com.daviddiazm.users.user.domain.models.RolUserModel;
import com.daviddiazm.users.user.domain.models.UserModel;

import java.util.List;

public interface UserServicePort {
    void saveUser(UserModel userModel);
}
