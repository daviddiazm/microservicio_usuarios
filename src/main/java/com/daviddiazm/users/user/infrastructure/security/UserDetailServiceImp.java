package com.daviddiazm.users.user.infrastructure.security;

import com.daviddiazm.users.user.infrastructure.entities.UserEntity;
import com.daviddiazm.users.user.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("no se encontro el usuario con el email "+email));

        System.out.println("este es el email "+ email);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_".concat(userEntity.getRolUserEntity().getName())));

        userEntity.getRolUserEntity().getPermissionList()
                .forEach(permissionEntity -> authorities.add(new SimpleGrantedAuthority(permissionEntity.getName())));

        User user =  new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNoExpired(),
                userEntity.isCredentialNoExpired(),
                userEntity.isAccountNoLocked(),
                authorities
        );

        System.out.println(user);

        return user;
    }
}
