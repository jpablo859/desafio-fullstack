package com.user.infraestructure.adapters.in.rest.controller;

import com.user.domain.User;
import com.user.infraestructure.adapters.in.rest.controller.mapper.UserMapper;
import com.user.infraestructure.adapters.in.rest.controller.request.CreateUserRequest;
import com.user.infraestructure.adapters.in.rest.controller.request.UpdateUserRequest;
import com.user.infraestructure.adapters.in.rest.controller.response.ApiResponse;
import com.user.infraestructure.adapters.in.rest.controller.response.UserResponse;
import com.user.infraestructure.ports.in.rest.UserController;
import com.user.infraestructure.ports.in.usecase.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Tag(name = "Usuario", description = "Operaciones relacionadas con usuarios")
@RequestMapping("user")
public class UserControllerImpl implements UserController {
    private final UserMapper userMapper;
    private final SaveUserUseCase saveUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final DeleteUserByIdUseCase deleteUserByIdUseCase;

    @Override
    public ResponseEntity<ApiResponse<UserResponse>> createUser(CreateUserRequest createUserRequest) throws Exception {
        User user = userMapper.toDomain(createUserRequest);
        User savedUser = saveUserUseCase.execute(user);

        return new ResponseEntity<>(
            ApiResponse.success(userMapper.toResponse(savedUser), "201"), HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers() {
        return ResponseEntity.ok(
            ApiResponse.success(userMapper.toResponse(getAllUsersUseCase.execute()), "200")
        );
    }

    @Override
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(Long id) {
        return ResponseEntity.ok(
            ApiResponse.success(userMapper.toResponse(getUserByIdUseCase.execute(id)), "200")
        );
    }

    @Override
    public ResponseEntity<ApiResponse<Object>> deleteUserById(Long id) {
        deleteUserByIdUseCase.execute(id);

        return ResponseEntity.ok(
            ApiResponse.success(null, "200")
        );
    }

    @Override
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(UpdateUserRequest updateUserRequest) throws Exception {
        User user = userMapper.toDomain(updateUserRequest);
        User updadUser = updateUserUseCase.execute(user);

        return ResponseEntity.ok(
            ApiResponse.success(userMapper.toResponse(updadUser), "200")
        );
    }
}
