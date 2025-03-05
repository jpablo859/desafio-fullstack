package com.user.infraestructure.adapters.out.database;

import com.user.domain.User;
import com.user.infraestructure.adapters.out.database.entities.UserEntity;
import com.user.infraestructure.adapters.out.database.mapper.UserEntityMapper;
import com.user.infraestructure.adapters.out.database.repositories.UserRepository;
import com.user.infraestructure.ports.out.UserPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserAdapter implements UserPort {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        UserEntity userSaved = userRepository.save(userEntity);

        return userEntityMapper.toDomain(userSaved);
    }

    @Override
    public List<User> getAllUsers() {
        return userEntityMapper.toDomain(userRepository.findAll());
    }

    @Override
    public User getUserById(Long id) {
        return userEntityMapper.toDomain(userRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
