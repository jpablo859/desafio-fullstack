package com.user.application.usecases;

import com.user.domain.User;
import com.user.infraestructure.ports.in.usecase.GetAllUsersUseCase;
import com.user.infraestructure.ports.out.UserPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {
    private final UserPort userPort;

    @Override
    public List<User> execute() {
        return userPort.getAllUsers();
    }
}
