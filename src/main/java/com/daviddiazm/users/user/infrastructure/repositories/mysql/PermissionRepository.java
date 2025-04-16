package com.daviddiazm.users.user.infrastructure.repositories.mysql;

import com.daviddiazm.users.user.infrastructure.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
    Optional<PermissionEntity> findByName(String name);
}
