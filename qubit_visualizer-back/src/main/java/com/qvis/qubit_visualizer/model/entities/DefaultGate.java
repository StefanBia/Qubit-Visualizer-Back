package com.qvis.qubit_visualizer.model.entities;

import java.io.Serializable;

public abstract class DefaultGate implements Gate, Serializable {

    Integer[][] matrix = {
            {1,0},
            {0,1}
    };

    @Override
    public void changeState() {

    }

    @Override
    public void changeBlochSphere() {

    }

    public Integer[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Integer[][] matrix) {
        this.matrix = matrix;
    }
}
