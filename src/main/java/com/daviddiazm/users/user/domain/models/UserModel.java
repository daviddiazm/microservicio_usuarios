package com.daviddiazm.users.user.domain.models;

import java.time.LocalDate;

public class UserModel {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthDay;
    private String email;
    private String password;
    private RolUserModel rolUserModel;

    public UserModel(Long id, String name, String lastName, LocalDate birthDay, String email, String password, RolUserModel rolUserModel) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
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

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rolUserModel=" + rolUserModel +
                '}';
    }
}
