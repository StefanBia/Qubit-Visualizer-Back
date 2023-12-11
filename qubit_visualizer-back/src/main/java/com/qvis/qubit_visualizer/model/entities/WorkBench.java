package com.qvis.qubit_visualizer.model.entities;

import com.qvis.qubit_visualizer.model.entities.User;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "workbench")
public class WorkBench implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private long workBenchId;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<BlochSphere> blochSpheres = new HashSet<BlochSphere>();

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

    public Set<BlochSphere> getBlochSpheres() {
        return blochSpheres;
    }

    public void setBlochSpheres(Set<BlochSphere> blochSpheres) {
        this.blochSpheres = blochSpheres;
    }
    public void addBlochSphere(BlochSphere blochSphere){
        this.blochSpheres.add(blochSphere);
    }
}
