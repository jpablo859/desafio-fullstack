package com.user.infraestructure.ports.in.usecase;

import com.user.domain.User;

public interface SaveUserUseCase {
    User execute(User user) throws Exception;
}
