package com.daviddiazm.users.user.infrastructure.adapters.persistence;

import com.daviddiazm.users.user.domain.models.UserModel;
import com.daviddiazm.users.user.domain.ports.out.UserPersistencePort;
import com.daviddiazm.users.user.infrastructure.entities.UserEntity;
import com.daviddiazm.users.user.infrastructure.mappers.UserEntityMapper;
import com.daviddiazm.users.user.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;


    @Override
    public String getPasswordHashed(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public void saveUser(UserModel userModel) {
        UserEntity user = userEntityMapper.modelToEntity(userModel);
        user.setId(null);
        userRepository.save(user);
    }

    @Override
    public Optional<UserModel> getUserByIdentification(String identification) {
        UserEntity user = userRepository.findByIdentification(identification);
        if (user == null) {
            return Optional.empty();
        } else {
            UserModel userModel = userEntityMapper.entityToModel(user);
            return Optional.of(userModel);
        }
    }
}
