package com.daviddiazm.users.user.infrastructure.repositories.mysql;

import com.daviddiazm.users.user.infrastructure.entities.RolUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolUserRepository extends JpaRepository<RolUserEntity, Long> {
    RolUserEntity getByName(String name);
}
