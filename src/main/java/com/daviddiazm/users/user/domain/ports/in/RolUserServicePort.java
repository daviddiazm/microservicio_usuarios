package com.daviddiazm.users.user.domain.ports.in;

import com.daviddiazm.users.user.domain.models.RolUserModel;

import java.util.List;

public interface RolUserServicePort {
    void saveRolUser(RolUserModel rolUserModel);
    List<RolUserModel> getAllRoles();

}
