package com.daviddiazm.users.user.infrastructure.mappers;

import com.daviddiazm.users.user.domain.models.RolUserModel;
import com.daviddiazm.users.user.infrastructure.entities.RolUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RolUserEntityMapper {
    RolUserEntity modelToEntity (RolUserModel rolUserModel);
    RolUserModel entityToModel(RolUserEntity rolUserEntity);

    List<RolUserModel> entityListToModelList (List<RolUserEntity> rolUserEntities );
}
