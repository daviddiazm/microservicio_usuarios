package com.daviddiazm.users.user.domain.utils.factories;

import com.daviddiazm.users.user.domain.models.RolUserModel;
import com.daviddiazm.users.user.domain.models.UserModel;

import java.time.LocalDate;
import java.util.List;

public class UserFactory {
    public static UserModel createUser () {
        Long id = 1L;
        String identification = "123455667";
        String name = "david";
        String lastName = "diaz montengro";
        String phoneNumber = "+5731176726737";
        LocalDate date = LocalDate.of(2003, 4,18);
        String email = "david@email.com";
        String password = "password";
        RolUserModel rol = new RolUserModel(1L, "vendedor", "esta es una descripcion", List.of());
        return new UserModel(id, identification, name, lastName, phoneNumber, date, email, password, rol);
    }
}
