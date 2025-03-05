package com.user.infraestructure.ports.in.usecase;

import com.user.domain.User;

public interface GetUserByIdUseCase {
    User execute(Long id);
}
