package com.qvis.qubit_visualizer.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_qub")
public class User implements Serializable {


    @Id
    @SequenceGenerator(
            name="q_sequence",
            sequenceName = "q_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false,updatable = false)
    private long UserId;

    private String username;

    private String firstName;

    private String lastName;


    public User(){

    }

    public User(long userId, String username, String firstName, String lastName) {
        UserId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
