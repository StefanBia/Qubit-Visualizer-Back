package com.qvis.qubit_visualizer.model.gates;

import com.qvis.qubit_visualizer.model.entities.DefaultGate;

public class Hadamard extends DefaultGate {

    public Hadamard() {
        Integer[][] matrix = {
                {1,1},
                {1,-1}
        };
        this.setMatrix(matrix);
    }
}
