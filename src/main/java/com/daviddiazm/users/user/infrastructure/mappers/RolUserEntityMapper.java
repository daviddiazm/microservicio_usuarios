package com.daviddiazm.users.user.infrastructure.mappers;

import com.daviddiazm.users.user.domain.models.RolUserModel;
import com.daviddiazm.users.user.infrastructure.entities.RolUserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolUserEntityMapper {
    RolUserEntity modelToEntity (RolUserModel rolUserModel);
    RolUserModel entityToModel(RolUserEntity rolUserEntity);
}
