package com.daviddiazm.users.user.domain.utils.validations;

import com.daviddiazm.users.user.domain.exceptions.InvalidPhoneNumberException;
import com.daviddiazm.users.user.domain.exceptions.LastNameMinException;
import com.daviddiazm.users.user.domain.exceptions.NameMaxException;
import com.daviddiazm.users.user.domain.exceptions.UnderAgeException;
import com.daviddiazm.users.user.domain.utils.constants.UserConstants;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class UserValidator {
    public static void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(UserConstants.FIELD_NAME_NULL_MESSAGE);
        }
        if (name.length() > UserConstants.MAX_NAME_CARACTER_LENGTH) {
            throw new NameMaxException(UserConstants.NAME_MAX_LENGHT);
        }
        if (name.length() < UserConstants.MIN_NAME_CARACTER_LENGTH) {
            throw new NameMaxException(UserConstants.NAME_MIN_LENGHT);
        }
    }

    public static void validateLastName(String lastNmae) {
        if (lastNmae == null) {
            throw new IllegalArgumentException(UserConstants.FIELD_LAST_NAME_NULL_MESSAGE);
        }
        if(lastNmae.length() < UserConstants.MIN_LAST_NAME_CARACTER_LENGTH) {
            throw new LastNameMinException(UserConstants.LAST_NAME_MIN_LENGHT);
        }
        if (lastNmae.length() > UserConstants.MAX_LAST_NAME_CARACTER_LENGTH) {
            throw new NameMaxException(UserConstants.LAST_NAME_MAX_LENGHT);
        }
    }

    public static void validateBirthday(LocalDate birthday) {
        if (birthday == null) {
            throw new IllegalArgumentException(UserConstants.FIELD_BIRTHDAY_NULL_MESSAGE);
        }

        if(!isValidBirthday(birthday)) {
            throw new UnderAgeException(UserConstants.UNDER_AGE_MESSAGE);
        }
    }
    private static boolean isValidBirthday (LocalDate birthday) {
        return birthday.plusYears(UserConstants.YEARS_OLD).isBefore(LocalDate.now())
            || birthday.plusYears(UserConstants.YEARS_OLD).isEqual(LocalDate.now());
    }


    public static void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException(UserConstants.FIELD_PHONE_NUMBER_NULL_MESSAGE);
        }
        if(phoneNumber.length() < UserConstants.MIN_PHONE_NUMBER_CARACTER_LENGTH) {
            throw new LastNameMinException(UserConstants.PHONE_NUMBER_MIN_LENGHT);
        }
        if (phoneNumber.length() > UserConstants.MAX_PHONE_NUMBER_CARACTER_LENGTH) {
            throw new NameMaxException(UserConstants.PHONE_NUMBER_MAX_LENGHT);
        }
        if(!isValidPhoneNumber(phoneNumber)) {
            throw new InvalidPhoneNumberException(UserConstants.PHONE_NUMBER_INVALID);
        }
    }
    private static boolean isValidPhoneNumber (String phoneNumber) {
        String regex = "^\\+?\\d+$";
        return Pattern.matches(regex, phoneNumber);
    }


    public static void validateEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException(UserConstants.FIELD_PHONE_NUMBER_NULL_MESSAGE);
        }
        if(email.length() < UserConstants.MIN_EMAIL_CARACTER_LENGTH) {
            throw new LastNameMinException(UserConstants.EMAIL_MIN_LENGHT);
        }
        if (email.length() > UserConstants.MAX_EMAIL_CARACTER_LENGTH) {
            throw new NameMaxException(UserConstants.EMAIL_MAX_LENGHT);
        }
        if(!isValidEmail(email)) {
            throw new InvalidPhoneNumberException(UserConstants.EMAIL_INVALID);
        }
    }
    private static boolean isValidEmail (String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(regex, email);
    }


}
