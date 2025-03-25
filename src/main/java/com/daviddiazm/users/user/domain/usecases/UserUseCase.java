package com.daviddiazm.users.user.domain.usecases;

import com.daviddiazm.users.user.domain.models.UserModel;
import com.daviddiazm.users.user.domain.ports.in.UserServicePort;
import com.daviddiazm.users.user.domain.ports.out.UserPersistencePort;

public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(UserModel userModel) {
        userModel.setPassword(userPersistencePort.getPasswordHashed(userModel.getPassword()));
        userPersistencePort.saveUser(userModel);
    }
}
