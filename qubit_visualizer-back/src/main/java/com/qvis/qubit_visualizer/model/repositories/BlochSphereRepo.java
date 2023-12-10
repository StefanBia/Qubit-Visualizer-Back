package com.qvis.qubit_visualizer.model.repositories;

import com.qvis.qubit_visualizer.model.entities.BlochSphere;
import com.qvis.qubit_visualizer.model.entities.WorkBench;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlochSphereRepo extends JpaRepository<BlochSphere, Long> {
    Optional<BlochSphere> findBlochSphereByBlochSphereId(Long id);
}
