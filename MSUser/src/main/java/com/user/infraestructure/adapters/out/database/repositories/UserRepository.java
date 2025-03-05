package com.user.infraestructure.adapters.out.database.repositories;

import com.user.infraestructure.adapters.out.database.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
