package com.daviddiazm.users.user.domain.models;

import java.time.LocalDate;

public class UserModel {
    private String id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private LocalDate birthDay;
    private String email;
    private String password;
    private RolUserModel rolUserModel;

    public UserModel(String id, String name, String lastName, String phoneNumber, LocalDate birthDay, String email, String password, RolUserModel rolUserModel) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.email = email;
        this.password = password;
        this.rolUserModel = rolUserModel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolUserModel getRolUserModel() {
        return rolUserModel;
    }

    public void setRolUserModel(RolUserModel rolUserModel) {
        this.rolUserModel = rolUserModel;
    }
}
