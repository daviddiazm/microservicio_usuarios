package com.daviddiazm.users.user.application.mappers;

import com.daviddiazm.users.user.application.dtos.requests.SaveRolUserRequest;
import com.daviddiazm.users.user.application.dtos.responses.RolUserResponse;
import com.daviddiazm.users.user.domain.models.RolUserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RolUserDtoMapper {
    RolUserModel requestToModel(SaveRolUserRequest saveRolUserRequest);
    List<RolUserModel> responseListToModelList( List<RolUserResponse> rolUserResponses );
    List<RolUserResponse> modelListToRequestList( List<RolUserModel> rolUserModels );
}
