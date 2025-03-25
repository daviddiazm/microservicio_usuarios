package com.daviddiazm.users.user.infrastructure.repositories.mysql;

import com.daviddiazm.users.user.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
