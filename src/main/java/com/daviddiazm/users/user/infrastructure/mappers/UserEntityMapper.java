package com.daviddiazm.users.user.infrastructure.mappers;

import com.daviddiazm.users.user.domain.models.UserModel;
import com.daviddiazm.users.user.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntity modelToEntity(UserModel userModel);
}
