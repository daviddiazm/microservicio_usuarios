package com.daviddiazm.users.user.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(
            targetEntity = UserEntity.class,
            mappedBy = "rolUserEntity"
    )
    List<UserEntity> users;
}
