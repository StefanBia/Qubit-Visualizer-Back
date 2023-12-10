package com.qvis.qubit_visualizer.model.repositories;

import com.qvis.qubit_visualizer.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByUserId(Long id);
}
