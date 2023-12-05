package com.qvis.qubit_visualizer.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "blochsphere")
public class BlochSphere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long BlochSphereId;

}
