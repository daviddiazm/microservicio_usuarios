package com.daviddiazm.users.user.domain.usecases;

import com.daviddiazm.users.user.domain.models.RolUserModel;
import com.daviddiazm.users.user.domain.ports.in.RolUserServicePort;
import com.daviddiazm.users.user.domain.ports.out.RolUserPersistencePort;

public class RolUserUseCase implements RolUserServicePort {

    private final RolUserPersistencePort rolUserPersistencePort;

    public RolUserUseCase(RolUserPersistencePort rolUserPersistencePort) {
        this.rolUserPersistencePort = rolUserPersistencePort;
    }

    @Override
    public void saveRolUser(RolUserModel rolUserModel) {
//        despues valido por ahora solo quiero que funcione el user
//        rolUserPersistencePort.getRolByName(rolUserModel.getName());
        rolUserPersistencePort.saveRolUser(rolUserModel);
    }
}
