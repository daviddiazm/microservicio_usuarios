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

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private RolUserEntity rolUserEntity;
}
