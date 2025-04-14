package com.daviddiazm.users.user.domain.utils.factories;

import com.daviddiazm.users.user.domain.models.RolUserModel;

import java.util.List;

public class RolUserFactory {
    public static RolUserModel create(){
        Long id = 1L;
        String name = "vendedor";
        String description = "es un vendedor de cosas";
        return new RolUserModel(id, name, description, List.of());
    }
}
