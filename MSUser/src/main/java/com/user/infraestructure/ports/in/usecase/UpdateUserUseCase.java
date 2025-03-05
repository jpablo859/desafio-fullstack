package com.user.infraestructure.ports.in.usecase;

import com.user.domain.User;

public interface UpdateUserUseCase {
    User execute(User user) throws Exception;
}
