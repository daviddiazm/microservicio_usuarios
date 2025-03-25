package com.daviddiazm.users.user.infrastructure.repositories.mysql;

import com.daviddiazm.users.user.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
