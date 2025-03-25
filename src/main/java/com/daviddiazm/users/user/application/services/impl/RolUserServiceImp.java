package com.daviddiazm.users.user.application.services.impl;

import com.daviddiazm.users.user.application.dtos.requests.SaveRolUserRequest;
import com.daviddiazm.users.user.application.dtos.responses.SaveRolUserResponse;
import com.daviddiazm.users.user.application.mappers.RolUserDtoMapper;
import com.daviddiazm.users.user.application.services.RolUserService;
import com.daviddiazm.users.user.domain.ports.out.RolUserPersistencePort;
import com.daviddiazm.users.user.domain.utils.constants.RolUserConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RolUserServiceImp implements RolUserService {

    private final RolUserDtoMapper rolUserDtoMapper;
    private final RolUserPersistencePort rolUserPersistencePort;

    @Override
    public SaveRolUserResponse saveRol(SaveRolUserRequest request) {
        rolUserPersistencePort.saveRolUser(rolUserDtoMapper.requestToModel(request));
        return new SaveRolUserResponse(RolUserConstants.SAVE_CORRECTLY_MESSAGE, LocalDate.now());
    }
}
