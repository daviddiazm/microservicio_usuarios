package com.daviddiazm.users.user.domain.utils.validations;

import com.daviddiazm.users.user.domain.exceptions.DescriptionMaxException;
import com.daviddiazm.users.user.domain.exceptions.DescriptionMinException;
import com.daviddiazm.users.user.domain.exceptions.NameMaxException;
import com.daviddiazm.users.user.domain.exceptions.NameMinException;
import com.daviddiazm.users.user.domain.utils.constants.RolUserConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RolUserValidatorTest {

    @Test
    void validateName_shouldNotThrowException_whenNameIsValid() {
        String validName = "ValidName";
        assertDoesNotThrow(() -> RolUserValidator.validateName(validName));
    }

    @Test
    void validateName_shouldThrowIllegalArgumentException_whenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> RolUserValidator.validateName(null));
    }

    @Test
    void validateName_shouldThrowNameMinException_whenNameIsTooShort() {
        String shortName = "a";
        assertThrows(NameMinException.class, () -> RolUserValidator.validateName(shortName));
    }

    @Test
    void validateName_shouldThrowNameMaxException_whenNameIsTooLong() {
        String longName = "a".repeat(RolUserConstants.MAX_NAME_CARACTER_LENGTH + 1);
        assertThrows(NameMaxException.class, () -> RolUserValidator.validateName(longName));
    }

    @Test
    void validateDescription_shouldNotThrowException_whenDescriptionIsValid() {
        String validDescription = "Valid Description";
        assertDoesNotThrow(() -> RolUserValidator.validateDescription(validDescription));
    }

    @Test
    void validateDescription_shouldThrowIllegalArgumentException_whenDescriptionIsNull() {
        assertThrows(IllegalArgumentException.class, () -> RolUserValidator.validateDescription(null));
    }

    @Test
    void validateDescription_shouldThrowDescriptionMinException_whenDescriptionIsTooShort() {
        String shortDescription = "a";
        assertThrows(DescriptionMinException.class, () -> RolUserValidator.validateDescription(shortDescription));
    }

    @Test
    void validateDescription_shouldThrowDescriptionMaxException_whenDescriptionIsTooLong() {
        String longDescription = "a".repeat(RolUserConstants.MAX_DESCRIPTION_CARACTER_LENGTH + 1);
        assertThrows(DescriptionMaxException.class, () -> RolUserValidator.validateDescription(longDescription));
    }
}