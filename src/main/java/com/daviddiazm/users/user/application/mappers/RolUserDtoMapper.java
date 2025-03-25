package com.daviddiazm.users.user.application.mappers;

import com.daviddiazm.users.user.application.dtos.requests.SaveRolUserRequest;
import com.daviddiazm.users.user.domain.models.RolUserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RolUserDtoMapper {
    RolUserModel requestToModel(SaveRolUserRequest saveRolUserRequest);
}
