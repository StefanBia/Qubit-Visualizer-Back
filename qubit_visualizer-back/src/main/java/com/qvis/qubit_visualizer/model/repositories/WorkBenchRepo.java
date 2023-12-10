package com.qvis.qubit_visualizer.model.repositories;

import com.qvis.qubit_visualizer.model.entities.WorkBench;
import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkBenchRepo extends JpaRepository<WorkBench, Long> {
    Optional<WorkBench> findWorkBenchByWorkBenchId(Long id);
}
