package com.qvis.qubit_visualizer.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class WorkBench implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private long WorkBenchId;


    @ManyToOne
    private User user;
    @OneToOne
    private BlochSphere blochSphere;
}
