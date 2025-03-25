package com.daviddiazm.users.commons.configurations.beans;

import com.daviddiazm.users.user.domain.ports.in.RolUserServicePort;
import com.daviddiazm.users.user.domain.ports.in.UserServicePort;
import com.daviddiazm.users.user.domain.ports.out.RolUserPersistencePort;
import com.daviddiazm.users.user.domain.ports.out.UserPersistencePort;
import com.daviddiazm.users.user.domain.usecases.RolUserUseCase;
import com.daviddiazm.users.user.domain.usecases.UserUseCase;
import com.daviddiazm.users.user.infrastructure.adapters.persistence.RolUserPersistenceAdapter;
import com.daviddiazm.users.user.infrastructure.adapters.persistence.UserPersistenceAdapter;
import com.daviddiazm.users.user.infrastructure.mappers.RolUserEntityMapper;
import com.daviddiazm.users.user.infrastructure.mappers.UserEntityMapper;
import com.daviddiazm.users.user.infrastructure.repositories.mysql.RolUserRepository;
import com.daviddiazm.users.user.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final RolUserRepository rolUserRepository;
    private final RolUserEntityMapper rolUserEntityMapper;

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Bean
    public RolUserServicePort rolUserServicePort() {
        return new RolUserUseCase(rolUserPersistencePort());
    }

    @Bean
    public RolUserPersistencePort rolUserPersistencePort() {
        return new RolUserPersistenceAdapter(rolUserRepository, rolUserEntityMapper);
    }

    @Bean
    public UserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserPersistenceAdapter(userRepository, userEntityMapper);
    }
}
