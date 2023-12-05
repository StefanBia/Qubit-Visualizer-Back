package com.qvis.qubit_visualizer.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity

public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private long UserId;
    private String username;
    private String firstName;
    private String lastName;
}
