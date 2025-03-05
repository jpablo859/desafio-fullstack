package com.user.application.usecases;

import com.user.domain.User;
import com.user.infraestructure.ports.in.usecase.GetUserByIdUseCase;
import com.user.infraestructure.ports.in.usecase.SaveUserUseCase;
import com.user.infraestructure.ports.in.usecase.UpdateUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    private final SaveUserUseCase saveUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public User execute(User user) throws Exception {
        getUserByIdUseCase.execute(user.getId());

        return saveUserUseCase.execute(user);
    }
}
