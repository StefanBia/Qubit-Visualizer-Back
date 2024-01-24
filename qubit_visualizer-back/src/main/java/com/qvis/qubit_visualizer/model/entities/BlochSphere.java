package com.qvis.qubit_visualizer.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "blochsphere")
public class BlochSphere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long blochSphereId;//Generate ID automatically
    private double lenX;
    private double lenY;
    private double lenZ;

    public BlochSphere(){}
    public BlochSphere(double lenX, double lenY, double lenZ) {
        this.lenX = lenX;
        this.lenY = lenY;
        this.lenZ = lenZ;
    }

    public double getLenX() {
        return lenX;
    }

    public void setLenX(double lenX) {
        this.lenX = lenX;
    }

    public double getLenY() {
        return lenY;
    }

    public void setLenY(double lenY) {
        this.lenY = lenY;
    }

    public double getLenZ() {
        return lenZ;
    }

    public void setLenZ(double lenZ) {
        this.lenZ = lenZ;
    }

    public long getBlochSphereId() {
        return blochSphereId;
    }
}
