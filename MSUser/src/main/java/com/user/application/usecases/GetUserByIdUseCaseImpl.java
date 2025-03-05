package com.user.application.usecases;

import com.user.application.exceptions.ApiException;
import com.user.domain.User;
import com.user.infraestructure.ports.in.usecase.GetUserByIdUseCase;
import com.user.infraestructure.ports.out.UserPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {
    private final UserPort userPort;

    @Override
    public User execute(Long id) {
        User user = userPort.getUserById(id);

        if (Objects.isNull(user))
            throw new ApiException("404", "El usuario con id " + id + " no existe");

        return user;
    }
}
