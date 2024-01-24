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
    private long workBenchId;//Generate ID automatically
    @OneToMany(cascade = CascadeType.ALL)
    private Set<BlochSphere> blochSpheres = new HashSet<BlochSphere>();

    @Column
    private String selectedGate;


    public WorkBench() {

    }


    public long getWorkBenchId() {
        return workBenchId;
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

    public String getSelectedGate() {
        return selectedGate;
    }

    public void setSelectedGate(String selectedGate) {
        this.selectedGate = selectedGate;
    }
}
