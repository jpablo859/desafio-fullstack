package com.user.infraestructure.adapters.out.database.mapper;

import com.user.domain.User;
import com.user.infraestructure.adapters.out.database.entities.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntity toEntity(User user);
    User toDomain(UserEntity userEntity);
    List<User> toDomain(List<UserEntity> userEntityList);
}
