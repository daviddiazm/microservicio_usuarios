package com.daviddiazm.users.user.domain.usecases;

import com.daviddiazm.users.user.domain.exceptions.NameAlreadyExistException;
import com.daviddiazm.users.user.domain.models.RolUserModel;
import com.daviddiazm.users.user.domain.ports.out.RolUserPersistencePort;
import com.daviddiazm.users.user.domain.utils.factories.RolUserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RolUserUseCaseTest {

    @Mock
    RolUserPersistencePort rolUserPersistencePort;

    @InjectMocks
    RolUserUseCase rolUserUseCase;

    @Test
    void saveRolUser_When_RolNameNotExist () {
        RolUserModel rol = RolUserFactory.create();

        when(rolUserPersistencePort.getRolByName(rol.getName())).thenReturn(null);
        rolUserUseCase.saveRolUser(rol);
        verify(rolUserPersistencePort).saveRolUser(rol);
    }

    @Test
    void saveRolUser_When_RolNameExist () {
        RolUserModel rol = RolUserFactory.create();
        RolUserModel newRol = RolUserFactory.create();

        when(rolUserPersistencePort.getRolByName(rol.getName())).thenReturn(newRol);

        assertThrows(NameAlreadyExistException.class, () -> rolUserUseCase.saveRolUser(rol) );
    }

}