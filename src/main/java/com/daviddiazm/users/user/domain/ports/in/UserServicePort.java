package com.daviddiazm.users.user.domain.ports.in;

import com.daviddiazm.users.user.domain.models.UserModel;

public interface UserServicePort {
    void saveUser(UserModel userModel);
}
