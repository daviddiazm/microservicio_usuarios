package com.daviddiazm.users.user.infrastructure.utils;

import com.daviddiazm.users.user.infrastructure.entities.PermissionEntity;
import com.daviddiazm.users.user.infrastructure.entities.RolUserEntity;
import com.daviddiazm.users.user.infrastructure.entities.UserEntity;
import com.daviddiazm.users.user.infrastructure.repositories.mysql.PermissionRepository;
import com.daviddiazm.users.user.infrastructure.repositories.mysql.RolUserRepository;
import com.daviddiazm.users.user.infrastructure.repositories.mysql.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final JdbcTemplate jdbcTemplate;
    private final RolUserRepository rolUserRepository;
    private final PermissionRepository permissionRepository;
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        verifyPermission("CREATE_USER");
        verifyPermission("READ_HOUSING");
        verifyPermission("CREATE_HOUSING");

        RolUserEntity adminRol = rolUserRepository.getByName("admin");

        if(adminRol == null) {
            jdbcTemplate.execute("INSERT INTO rol (name, description) VALUES ('admin', 'es administrador de la aplicacion')");
        }

        Long permissionCreateUserId = getPermissionId("CREATE_USER");
        Long permissionCreateHousingId = getPermissionId("CREATE_HOUSING");
        Long permissionReadHousingId = getPermissionId("READ_HOUSING");


        assignPermissionIfNotExists(adminRol.getId(), permissionCreateUserId);
        assignPermissionIfNotExists(adminRol.getId(), permissionCreateHousingId);
        assignPermissionIfNotExists(adminRol.getId(), permissionReadHousingId);

        UserEntity user = userRepository.findById(1L).orElse(null);

        if(user == null) {
            jdbcTemplate.execute("INSERT INTO `user` (`id`, `account_no_expired`, `account_no_locked`, `birth_day`, `credential_no_expired`, `email`, `identification`, `is_enabled`, `last_name`, `name`, `password`, `phone_number`, `rol_id`) VALUES ('1', b'0000', b'0000', '2000-04-01', b'0000', 'admin@email.com', '123456789', b'00000', 'admin', 'admin', '$2a$10$RnqxX1QnJBmAC3l0QFTkQ.EzyzayAELY5sg4Y.HBpjtdG1spMYeYC', '3117672673', '1');");
        }

    }

    private void verifyPermission(String namePermission) {
        Optional<PermissionEntity> permission = permissionRepository.findByName(namePermission);
        if(permission.isEmpty()) {
            jdbcTemplate.execute("INSERT INTO permission (name) VALUES ('"+namePermission+"')");
        }
    }

    private Long getPermissionId(String permissionName) {
        return permissionRepository.findByName(permissionName)
                .orElseThrow(() -> new RuntimeException("Permiso no encontrado: " + permissionName))
                .getId();
    }

    private void assignPermissionIfNotExists(Long roleId, Long permissionId) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM role_permissions WHERE role_id = ? AND permission_id = ?",
                Integer.class,
                roleId,
                permissionId
        );

        if (count == null || count == 0) {
            jdbcTemplate.update(
                    "INSERT INTO role_permissions (role_id, permission_id) VALUES (?, ?)",
                    roleId,
                    permissionId
            );
        }
    }
}
