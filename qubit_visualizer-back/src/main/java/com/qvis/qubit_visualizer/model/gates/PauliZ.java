package com.qvis.qubit_visualizer.model.gates;

import com.qvis.qubit_visualizer.model.entities.DefaultGate;

public class PauliZ extends DefaultGate {

    public PauliZ() {
        Integer[][] matrix = {
                {1,0},
                {0,-1}
        };
        this.setMatrix(matrix);
    }
}
