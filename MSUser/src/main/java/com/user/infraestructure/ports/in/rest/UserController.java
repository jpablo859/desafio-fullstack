package com.user.infraestructure.ports.in.rest;

import com.user.infraestructure.adapters.in.rest.controller.request.CreateUserRequest;
import com.user.infraestructure.adapters.in.rest.controller.request.UpdateUserRequest;
import com.user.infraestructure.adapters.in.rest.controller.response.ApiResponse;
import com.user.infraestructure.adapters.in.rest.controller.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

public interface UserController {
    @PostMapping("/create")
    ResponseEntity<ApiResponse<UserResponse>> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) throws Exception;

    @GetMapping("/all")
    ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers();

    @GetMapping("/by-id/{id}")
    ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable("id") Long id);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ApiResponse<Object>> deleteUserById(@PathVariable("id") Long id);

    @PutMapping("/update")
    ResponseEntity<ApiResponse<UserResponse>> updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest) throws Exception;
}
