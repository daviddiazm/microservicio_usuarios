package com.daviddiazm.users.user.infrastructure.exceptionshandler;

import com.daviddiazm.users.user.domain.exceptions.*;
import com.daviddiazm.users.user.domain.utils.constants.RolUserConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

public class ControllerAdvisor {
    @ExceptionHandler(NameAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleNameAlreadyException(NameAlreadyExistException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(RolUserConstants.NAME_ALREADY_EXIST, LocalDateTime.now()));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleUserAlreadyExistException(UserAlreadyExistException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(NameMinException.class)
    public ResponseEntity<ExceptionResponse> handleNameMinException(NameMinException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(NameMaxException.class)
    public ResponseEntity<ExceptionResponse> handleNameMaxException(NameMaxException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(DescriptionMinException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionMinException(DescriptionMinException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(DescriptionMaxException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionMaxException(DescriptionMaxException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(InvalidEmialException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidEmailException(InvalidEmialException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(InvalidPhoneNumberException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidPhoneNumberException(InvalidPhoneNumberException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(UnderAgeException.class)
    public ResponseEntity<ExceptionResponse> handleUnderAgeException(UnderAgeException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(LastNameMinException.class)
    public ResponseEntity<ExceptionResponse> handleLastNameMinException(LastNameMinException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(DepartmentIdNotExistException.class)
    public ResponseEntity<ExceptionResponse> handleDepartmentIdNotExistException(DepartmentIdNotExistException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(CategoryNotExistException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryNotExistException(CategoryNotExistException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(PageMinNumbreSizeException.class)
    public ResponseEntity<ExceptionResponse> handlePageMinNumbreSizeException(PageMinNumbreSizeException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(PageMinNumbrePageException.class)
    public ResponseEntity<ExceptionResponse> handlePageMinNumbrePageException(PageMinNumbrePageException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

}
