package com.daviddiazm.users.user.domain.usecases;

import com.daviddiazm.users.user.domain.exceptions.*;
import com.daviddiazm.users.user.domain.models.UserModel;
import com.daviddiazm.users.user.domain.ports.out.UserPersistencePort;
import com.daviddiazm.users.user.domain.utils.factories.UserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {

    @Mock
    UserPersistencePort userPersistencePort;

    @InjectMocks
    UserUseCase userUseCase;

    @Test
    void saveUser_shouldSaveUser_whenUserDoesNotExist() {
        UserModel userModel = UserFactory.createUser();

        when(userPersistencePort.getUserByIdentification(userModel.getIdentification())).thenReturn(Optional.empty());
        when(userPersistencePort.getPasswordHashed(userModel.getPassword())).thenReturn("hashedPassword");

        userUseCase.saveUser(userModel);

        verify(userPersistencePort, times(1)).saveUser(userModel);
    }

    @Test
    void saveUser_shouldThrowUserAlreadyExistException_whenUserExists() {
        UserModel userModel = UserFactory.createUser();

        when(userPersistencePort.getUserByIdentification(userModel.getIdentification())).thenReturn(Optional.of(userModel));

        assertThrows(UserAlreadyExistException.class, () -> userUseCase.saveUser(userModel));

        verify(userPersistencePort, never()).saveUser(userModel);
    }

    @Test
    void saveUser_shouldHashPassword_beforeSavingUser() {
        UserModel userModel = UserFactory.createUser();

        when(userPersistencePort.getUserByIdentification(userModel.getIdentification())).thenReturn(Optional.empty());
        when(userPersistencePort.getPasswordHashed(userModel.getPassword())).thenReturn("hashedPassword");

        userUseCase.saveUser(userModel);

        assertEquals("hashedPassword", userModel.getPassword());
        verify(userPersistencePort, times(1)).saveUser(userModel);
    }

    @Test
    void saveUser_shouldValidateName() {
        UserModel userModel = UserFactory.createUser();

        userModel.setName("");
        when(userPersistencePort.getUserByIdentification(userModel.getIdentification())).thenReturn(Optional.empty());
        assertThrows(NameMinException.class, () -> userUseCase.saveUser(userModel));
    }

    @Test
    void saveUser_shouldValidateLastName() {
        UserModel userModel = UserFactory.createUser();

        userModel.setLastName("");
        when(userPersistencePort.getUserByIdentification(userModel.getIdentification())).thenReturn(Optional.empty());
        assertThrows(LastNameMinException.class, () -> userUseCase.saveUser(userModel));
    }

    @Test
    void saveUser_shouldValidateBirthday() {
        UserModel userModel = UserFactory.createUser();

        userModel.setBirthDay(LocalDate.now().plusDays(1));
        when(userPersistencePort.getUserByIdentification(userModel.getIdentification())).thenReturn(Optional.empty());
        assertThrows(UnderAgeException.class, () -> userUseCase.saveUser(userModel));
    }

    @Test
    void saveUser_shouldValidatePhoneNumber() {
        UserModel userModel = UserFactory.createUser();

        userModel.setPhoneNumber("invalid8910");
        when(userPersistencePort.getUserByIdentification(userModel.getIdentification())).thenReturn(Optional.empty());
        assertThrows(InvalidPhoneNumberException.class, () -> userUseCase.saveUser(userModel));
    }

    @Test
    void saveUser_shouldValidateEmail() {
        UserModel userModel = UserFactory.createUser();

        userModel.setEmail("invalid");
        when(userPersistencePort.getUserByIdentification(userModel.getIdentification())).thenReturn(Optional.empty());
        assertThrows(InvalidEmialException.class, () -> userUseCase.saveUser(userModel));
    }

}