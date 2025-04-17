package com.daviddiazm.users.user.infrastructure.security;

import com.daviddiazm.users.commons.configurations.beans.PasswordConfig;
import com.daviddiazm.users.user.application.dtos.requests.LoginUserRequest;
import com.daviddiazm.users.user.application.dtos.responses.LoginUserResponse;
import com.daviddiazm.users.user.infrastructure.entities.UserEntity;
import com.daviddiazm.users.user.infrastructure.repositories.mysql.UserRepository;
import com.daviddiazm.users.user.infrastructure.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final JwtUtils jwtUtils;
    private final PasswordConfig passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("no se encontro el usuario con el email "+email));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_".concat(userEntity.getRolUserEntity().getName())));

        userEntity.getRolUserEntity().getPermissionList()
                .forEach(permissionEntity -> authorities.add(new SimpleGrantedAuthority(permissionEntity.getName())));

        return new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNoExpired(),
                userEntity.isCredentialNoExpired(),
                userEntity.isAccountNoLocked(),
                authorities
        );
    }

    public LoginUserResponse loginUser(LoginUserRequest request) {
        String email = request.email();
        String password = request.password();

        Authentication authentication = authenticate(email, password);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);
        return new LoginUserResponse(email, "user login succesfuly", accessToken, true);
    }

    public Authentication authenticate(String email, String password) {
        UserDetails user = this.loadUserByUsername(email);
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("no se encontro el usuario con el email "+email));

        if(user == null) {
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!passwordEncoder.passwordEncoder().matches(password, user.getPassword())) {
            throw new BadCredentialsException("Incorrect Password");
        }
        return new UsernamePasswordAuthenticationToken(userEntity.getId() , user.getPassword(), user.getAuthorities());
    }
}
