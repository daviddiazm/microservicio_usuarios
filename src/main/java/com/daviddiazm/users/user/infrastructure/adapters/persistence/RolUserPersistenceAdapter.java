package com.daviddiazm.users.user.infrastructure.adapters.persistence;

import com.daviddiazm.users.user.domain.models.RolUserModel;
import com.daviddiazm.users.user.domain.ports.out.RolUserPersistencePort;
import com.daviddiazm.users.user.infrastructure.entities.RolUserEntity;
import com.daviddiazm.users.user.infrastructure.mappers.RolUserEntityMapper;
import com.daviddiazm.users.user.infrastructure.repositories.mysql.RolUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RolUserPersistenceAdapter implements RolUserPersistencePort {

    private final RolUserRepository rolUserRepository;
    private final RolUserEntityMapper rolUserEntityMapper;

    @Override
    public void saveRolUser(RolUserModel rolUserModel) {
        RolUserEntity rol = rolUserEntityMapper.modelToEntity(rolUserModel);
        rolUserRepository.save(rol);
    }

    @Override
    public RolUserModel getRolByName(String name) {
        return rolUserEntityMapper.entityToModel(rolUserRepository.getByName(name));
    }
}
