package com.qvis.qubit_visualizer.model.gates;

import com.qvis.qubit_visualizer.model.entities.Gate;

public abstract class DefaultGate implements Gate {
    private Integer[][] matrix;

    public Integer[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Integer[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Integer[] changeState(Integer[] state) {
        // Default behavior or placeholder
        return null;
    }

    @Override
    public void changeBlochSphere() {
        // Default behavior or placeholder
        System.out.println("Bloch Sphere changed by " + this.getClass().getSimpleName());
    }
}