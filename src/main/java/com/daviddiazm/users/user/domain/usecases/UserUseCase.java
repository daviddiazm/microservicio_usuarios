package com.daviddiazm.users.user.domain.usecases;

import com.daviddiazm.users.user.domain.exceptions.UserAlreadyExistException;
import com.daviddiazm.users.user.domain.models.UserModel;
import com.daviddiazm.users.user.domain.ports.in.UserServicePort;
import com.daviddiazm.users.user.domain.ports.out.UserPersistencePort;
import com.daviddiazm.users.user.domain.utils.constants.UserConstants;
import com.daviddiazm.users.user.domain.utils.validations.UserValidator;

import java.util.Optional;

public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(UserModel userModel) {
        Optional<UserModel> userExist = userPersistencePort.getUserByIdentification(userModel.getIdentification());
        if(userExist.isPresent()) {
            throw new UserAlreadyExistException(UserConstants.USER_ALREADY_EXIST);
        }
        UserValidator.validateName(userModel.getName());
        UserValidator.validateLastName(userModel.getLastName());
        UserValidator.validateBirthday(userModel.getBirthday());
        UserValidator.validatePhoneNumber(userModel.getPhoneNumber());
        UserValidator.validateEmail(userModel.getEmail());

        userModel.setPassword(userPersistencePort.getPasswordHashed(userModel.getPassword()));
        userPersistencePort.saveUser(userModel);
    }
}
