package com.qvis.qubit_visualizer.model.repositories;

import com.qvis.qubit_visualizer.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByUserId(Long id);//Create JPA query for finding User by ID
    Optional<User> findUserByUsername(String username);//Create JPA query for finding user by username
}
