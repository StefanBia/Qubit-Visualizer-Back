package com.qvis.qubit_visualizer.model.entities;

import jakarta.persistence.*;
import org.hibernate.jdbc.Work;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private long userId;//Generate ID automatically using sequence
    private String username;

    private String firstName;

    private String lastName;

    private String password;
    @OneToMany
    private Set<WorkBench> workBenches = new HashSet<WorkBench>();


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<WorkBench> getWorkBenches() {
        return workBenches;
    }

    public void setWorkBenches(Set<WorkBench> workBenches) {
        this.workBenches = workBenches;
    }

    public void addWorkBench(WorkBench workBench){
        this.workBenches.add(workBench);
    }

    public long getUserId() {
        return userId;
    }
}
