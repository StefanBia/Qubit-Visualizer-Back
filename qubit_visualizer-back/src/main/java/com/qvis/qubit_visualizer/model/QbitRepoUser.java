package com.qvis.qubit_visualizer.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QbitRepoUser extends JpaRepository<User, Long> {
//    Optional<User> findUserByUserId(Long id);
}
