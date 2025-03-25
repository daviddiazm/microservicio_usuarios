package com.daviddiazm.users.user.application.mappers;

import com.daviddiazm.users.user.application.dtos.requests.SaveUserRequest;
import com.daviddiazm.users.user.domain.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDtoMapper {
    @Mapping(source = "rolUser", target = "rolUserModel.id")
    UserModel requestToModel (SaveUserRequest saveUserRequest);
}
