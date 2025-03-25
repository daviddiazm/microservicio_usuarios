package com.daviddiazm.users.user.domain.ports.out;

import com.daviddiazm.users.user.domain.models.UserModel;

public interface UserPersistencePort {
    String getPasswordHashed(String password);
    void saveUser (UserModel userModel);
}
