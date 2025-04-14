package com.daviddiazm.users.user.domain.utils.validations;

import com.daviddiazm.users.user.domain.exceptions.DescriptionMaxException;
import com.daviddiazm.users.user.domain.exceptions.DescriptionMinException;
import com.daviddiazm.users.user.domain.exceptions.NameMaxException;
import com.daviddiazm.users.user.domain.exceptions.NameMinException;
import com.daviddiazm.users.user.domain.utils.constants.RolUserConstants;

public class RolUserValidator {
    public static void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(RolUserConstants.FIELD_NAME_NULL_MESSAGE);
        }
        if (name.length() < RolUserConstants.MIN_NAME_CARACTER_LENGTH) {
            throw new NameMinException(RolUserConstants.NAME_MIN_LENGHT);
        }
        if (name.length() > RolUserConstants.MAX_NAME_CARACTER_LENGTH) {
            throw new NameMaxException(RolUserConstants.NAME_MAX_LENGHT);
        }
    }

    public static void validateDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException(RolUserConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        if (description.length() < RolUserConstants.MIN_DESCRIPTION_CARACTER_LENGTH) {
            throw new DescriptionMinException(RolUserConstants.DESCRIPTION_MIN_LENGHT);
        }
        if (description.length() > RolUserConstants.MAX_DESCRIPTION_CARACTER_LENGTH) {
            throw new DescriptionMaxException(RolUserConstants.DESCRIPTION_MAX_LENGHT);
        }
    }
}
