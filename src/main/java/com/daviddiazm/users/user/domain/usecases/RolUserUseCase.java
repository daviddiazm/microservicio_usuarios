package com.daviddiazm.users.user.domain.usecases;

import com.daviddiazm.users.user.domain.exceptions.NameAlreadyExistException;
import com.daviddiazm.users.user.domain.models.RolUserModel;
import com.daviddiazm.users.user.domain.ports.in.RolUserServicePort;
import com.daviddiazm.users.user.domain.ports.out.RolUserPersistencePort;
import com.daviddiazm.users.user.domain.utils.constants.RolUserConstants;
import com.daviddiazm.users.user.domain.utils.validations.RolUserValidator;

public class RolUserUseCase implements RolUserServicePort {

    private final RolUserPersistencePort rolUserPersistencePort;

    public RolUserUseCase(RolUserPersistencePort rolUserPersistencePort) {
        this.rolUserPersistencePort = rolUserPersistencePort;
    }

    @Override
    public void saveRolUser(RolUserModel rolUserModel) {
        rolUserModel.setName(rolUserModel.getName().toLowerCase());
        RolUserValidator.validateName(rolUserModel.getName());
        RolUserValidator.validateDescription(rolUserModel.getDescription());
        RolUserModel rolExist = rolUserPersistencePort.getRolByName(rolUserModel.getName());
        if(rolExist != null){
            throw new NameAlreadyExistException(RolUserConstants.NAME_ALREADY_EXIST);
        }
        rolUserPersistencePort.saveRolUser(rolUserModel);
    }
}
