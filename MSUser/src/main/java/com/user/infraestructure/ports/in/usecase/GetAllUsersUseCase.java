package com.user.infraestructure.ports.in.usecase;

import com.user.domain.User;

import java.util.List;

public interface GetAllUsersUseCase {
    List<User> execute();
}
