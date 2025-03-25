package com.daviddiazm.users.user.domain.usecases;

import com.daviddiazm.users.user.domain.models.UserModel;
import com.daviddiazm.users.user.domain.ports.out.UserPersistencePort;
import com.daviddiazm.users.user.domain.utils.factories.UserFactory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class UserUseCaseTest {

    @Mock
    UserPersistencePort userPersistencePort;

    @InjectMocks
    UserUseCase userUseCase;

//    @Test
//    void saveUser() {
//        UserModel user = UserFactory.createUser();
//        String hased = userPersistencePort.getPasswordHashed(user.getPassword());
//        assertEquals("hola", hased);
//    }
}