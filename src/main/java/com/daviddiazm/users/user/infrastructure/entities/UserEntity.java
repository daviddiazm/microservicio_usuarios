package com.daviddiazm.users.user.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identification;
    private String name;
    private String lastName;
    private String phoneNumber;
    private LocalDate birthDay;
    private String email;
    private String password;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "account_No_Expired")
    private boolean accountNoExpired;

    @Column(name = "account_No_Locked")
    private boolean accountNoLocked;

    @Column(name = "credential_No_Expired")
    private boolean credentialNoExpired;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private RolUserEntity rolUserEntity;
}
