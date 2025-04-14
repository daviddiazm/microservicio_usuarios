package com.daviddiazm.users.user.domain.ports.out;

import com.daviddiazm.users.user.domain.models.RolUserModel;

public interface RolUserPersistencePort {
    void saveRolUser(RolUserModel rolUserModel);
    RolUserModel getRolByName(String name);
}
