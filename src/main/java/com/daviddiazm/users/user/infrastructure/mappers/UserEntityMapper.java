package com.daviddiazm.users.user.infrastructure.mappers;

import com.daviddiazm.users.user.domain.models.UserModel;
import com.daviddiazm.users.user.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    @Mapping(source = "rolUserModel.id", target = "rolUserEntity.id")
    UserEntity modelToEntity(UserModel userModel);
}
