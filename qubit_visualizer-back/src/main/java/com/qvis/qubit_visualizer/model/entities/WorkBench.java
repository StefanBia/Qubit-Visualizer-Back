package com.qvis.qubit_visualizer.model.entities;

import com.qvis.qubit_visualizer.model.entities.User;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "workbench")
public class WorkBench implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private long workBenchId;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public WorkBench(User user) {
        this.user = user;
    }

    public WorkBench() {

    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getWorkBenchId() {
        return workBenchId;
    }

    public User getUser() {
        return user;
    }
}
