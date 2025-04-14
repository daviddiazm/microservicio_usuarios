package com.daviddiazm.users.user.infrastructure.mappers;

import com.daviddiazm.users.user.domain.models.UserModel;
import com.daviddiazm.users.user.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    @Mapping(source = "rolUserModel.id", target = "rolUserEntity.id")
    UserEntity modelToEntity(UserModel userModel);

    @Mapping(source = "rolUserEntity.id", target = "rolUserModel.id")
    UserModel entityToModel (UserEntity userEntity);
}
