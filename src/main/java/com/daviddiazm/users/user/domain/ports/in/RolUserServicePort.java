package com.daviddiazm.users.user.domain.ports.in;

import com.daviddiazm.users.user.domain.models.RolUserModel;

public interface RolUserServicePort {
    void saveRolUser(RolUserModel rolUserModel);
}
