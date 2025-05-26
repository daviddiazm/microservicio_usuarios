package com.daviddiazm.users.user.domain.models;

import java.time.LocalDate;

public class UserModel {

    private Long id;
    private String identification;
    private String name;
    private String lastName;
    private String phoneNumber;
    private LocalDate birthday;
    private String email;
    private String password;
    private RolUserModel rolUserModel;

    public UserModel() {
    }

    public UserModel(Long id, String identification, String name, String lastName, String phoneNumber, LocalDate birthday, String email, String password, RolUserModel rolUserModel) {
        this.id = id;
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.rolUserModel = rolUserModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", identification='" + identification + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rolUserModel=" + rolUserModel +
                '}';
    }
}
