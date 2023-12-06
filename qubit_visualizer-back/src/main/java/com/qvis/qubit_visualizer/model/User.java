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
    private long userId;

    private String username;

    private String firstName;

    private String lastName;
//    @OneToMany
//    private List<WorkBench> workBenches;


    public User(){

    }

    public User(String username, String firstName, String lastName) {

        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
