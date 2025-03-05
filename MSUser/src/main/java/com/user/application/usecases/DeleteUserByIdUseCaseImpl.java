package com.user.application.usecases;

import com.user.infraestructure.ports.in.usecase.DeleteUserByIdUseCase;
import com.user.infraestructure.ports.in.usecase.GetUserByIdUseCase;
import com.user.infraestructure.ports.out.UserPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUserByIdUseCaseImpl implements DeleteUserByIdUseCase {
    private final UserPort userPort;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public void execute(Long id) {
        getUserByIdUseCase.execute(id);
        userPort.deleteUserById(id);
    }
}
