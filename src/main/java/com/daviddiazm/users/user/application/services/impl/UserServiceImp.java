package com.daviddiazm.users.user.application.services.impl;

import com.daviddiazm.users.user.application.dtos.requests.SaveUserRequest;
import com.daviddiazm.users.user.application.dtos.responses.SaveUserResponse;
import com.daviddiazm.users.user.application.mappers.UserDtoMapper;
import com.daviddiazm.users.user.application.services.UserService;
import com.daviddiazm.users.user.domain.ports.in.UserServicePort;
import com.daviddiazm.users.user.domain.utils.constants.UserConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserServicePort userServicePort;
    private final UserDtoMapper userDtoMapper;

    @Override
    public SaveUserResponse saveUser(SaveUserRequest saveUserRequest) {
        System.out.println("lo que llega del request");
        System.out.println(saveUserRequest);

        System.out.println("el mapper app");
        System.out.println(userDtoMapper.requestToModel(saveUserRequest));
        userServicePort.saveUser(userDtoMapper.requestToModel(saveUserRequest));
        return new SaveUserResponse(UserConstants.SAVE_CORRECTLY_MESSAGE, LocalDate.now());
    }
}
