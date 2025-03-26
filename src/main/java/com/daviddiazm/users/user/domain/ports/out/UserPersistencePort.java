package com.daviddiazm.users.user.domain.ports.out;

import com.daviddiazm.users.user.domain.models.UserModel;

import java.util.Optional;

public interface UserPersistencePort {
    String getPasswordHashed(String password);
    void saveUser (UserModel userModel);
    Optional<UserModel> getUserByIdentification (String identification);
}
