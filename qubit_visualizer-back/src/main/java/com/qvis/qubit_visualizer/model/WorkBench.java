package com.qvis.qubit_visualizer.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "workbench")
public class WorkBench implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private long WorkBenchId;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;




}
