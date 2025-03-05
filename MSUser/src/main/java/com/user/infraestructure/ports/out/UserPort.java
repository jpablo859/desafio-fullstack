package com.user.infraestructure.ports.out;

import com.user.domain.User;

import java.util.List;

public interface UserPort {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUserById(Long id);
}
