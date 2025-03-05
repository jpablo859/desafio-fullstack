package com.user.infraestructure.adapters.in.rest.controller.mapper;

import com.user.domain.User;
import com.user.infraestructure.adapters.in.rest.controller.request.CreateUserRequest;
import com.user.infraestructure.adapters.in.rest.controller.request.UpdateUserRequest;
import com.user.infraestructure.adapters.in.rest.controller.response.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDomain(UpdateUserRequest updateUserRequest);
    User toDomain(CreateUserRequest createUserRequest);
    UserResponse toResponse(User user);
    List<UserResponse> toResponse(List<User> userList);
}
